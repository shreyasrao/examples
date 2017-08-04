import os, sys

targetDir = sys.argv[1]

for root, _dir, files in os.walk(targetDir):
	for f in files:
		if ".pgm" in f:
			#print(f.replace('.pgm','.jpg'))
			newF = f.replace('.pgm','.jpg')
			os.rename(os.path.join(root,f),os.path.join(root,newF))
