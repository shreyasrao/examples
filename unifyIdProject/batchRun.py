import os, sys, re
import subprocess
from shutil import copyfile

def getSubject(fileName):
        return fileName.split("-")[1]

def analyzeRun(enrolledImg, res):
	trueSubject = getSubject(enrolledImg)

	runStats = {'enrolled': enrolledImg, 'fP': 0, 'tP': 0, 'fN': 0, 'tN':0}

	for r in res.splitlines():
		if "unknown" in r:
			#print(r)
			continue
			#this image was not detected
			
			testSubject = getSubject(r)
			if testSubject==trueSubject:
				runStats['fN'] = runStats['fN']+1
			else:
				runStats['tN'] = runStats['tN']+1

		if "enrolled" in r:
			testSubject = getSubject(r)
			print("Found: " + testSubject + ". Actual subject was: " + trueSubject)
			if testSubject==trueSubject:
				runStats['tP'] = runStats['tP']+1
			else:
				runStats['fP'] = runStats['fP']+1
	
	print(runStats)
	return runStats



def runDetection(enrolledImg):
	print("RUNNING AGAINST: " + enrolledImg)
	proc = subprocess.Popen(['face_recognition', 'known/',  'all/'], stdout=subprocess.PIPE, stderr=subprocess.STDOUT)

	res = proc.communicate()[0].decode("utf-8")
	return analyzeRun(enrolledImg,res)
        #print(res)

def updateGlobalStats(g,r):
	g['tP'] = g['tP'] + r['tP']
	g['tN'] = g['tN'] + r['tN']
	g['fP'] = g['fP'] + r['fP']
	g['fN'] = g['fN'] + r['fN']


# Begin my running all against empty. Look for WARNING
# Split lines, identify the file name and move the image to noID folder
proc = subprocess.Popen(['face_recognition', 'all/',  'empty/'], stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
res = proc.communicate()[0].decode("utf-8")
for line in res.splitlines():
	if "WARNING" in line:
		msg = line.split(" ")
		noIdFile = msg[-3][:-1]
		print("Moving: " + noIdFile)
		os.rename(noIdFile,"noFaceDetected/"+noIdFile)


globalStats = {'fP': 0, 'tP': 0, 'fN': 0, 'tN':0}

for root,dirs,files in os.walk("all/"):
	for f in files:
		enrolledImg = f
		copyfile(os.path.join(root,f),"known/enrolled.jpg")
		#print(f)
		runRes = runDetection(f)
		updateGlobalStats(globalStats,runRes)

print(globalStats)
