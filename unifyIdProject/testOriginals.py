import os, sys
import face_recognition


typeDir = sys.argv[1]
print("Running all " + typeDir + " images against image in all/known dir")


for _root,_dirs,files in os.walk("all/known"):
	#print(os.path.join(_root,files[0]))
	knownImagePath = os.path.join(_root,files[0])

knownImage = face_recognition.load_image_file(knownImagePath)
knownEncoding = face_recognition.face_encodings(knownImage)[0]
knownSubject = files[0].split('-')[1] 
print(knownSubject)


unknownImage = face_recognition.load_image_file(knownImagePath)
unknownEncoding = face_recognition.face_encodings(unknownImage)[0]

res = face_recognition.compare_faces([knownEncoding],unknownEncoding)

if res[0] == True:
	print("MY FACE")
	#print(unknownSubject)	
else:
	print("NOT MEEEEEEEEEEE")

'''
for _root,_dirs,testImages in os.walk("all/" + typeDir):
	for testImage in testImages:
		#print(testImage)
		testImage
'''
