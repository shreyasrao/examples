import os
import sys, re

subjectlist = [];
print("Changing all of the img names located in : " + sys.argv[1])


for root,subjects,notUsed in os.walk(sys.argv[1], topdown=False):
	for dirName in subjects:
		subjectlist.append(os.path.join(root,dirName))

for subjectTypeDir in subjectlist:
	#print(subjectTypeDir)
	for root,notUseddirs,files in os.walk(subjectTypeDir):
		prefix = subjectTypeDir.replace('/','-')
		for f in files:
			if "DS_Store" in f:
				print("skipping :" + f)
				continue
			#print(prefix+f)	
			origF = os.path.join(root,f)		
			print("rename:" + origF)		
			newFileName = origF.replace('/','-')
			pathToImg = root + "/"
			#print("place in:"+ pathToImg)
			#print("all/"+ newFileName)
			newF = "all/"+ newFileName
			os.rename(origF,newF)
