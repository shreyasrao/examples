import os
import sys, re

for notUsedRoot, notUsedDirs,files in os.walk("all"):
	if not os.path.exists("all/smile") :
		os.mkdir("all/smile")
	if not os.path.exists("all/neutral"):
		os.mkdir("all/neutral")
	for f in files:
		if "smile" in f:
			#print(os.path.exists("all/"+f))
			os.rename("all/" + f,"all/smile/"+f)
		elif "neutral" in f:
			#print("")
			os.rename("all/"+f,"all/neutral/"+f)
		else:
			print("UNCLASSIFICED file: " + f)
