import face_recognition
import sys,os

knownFilePath = sys.argv[1]
unknownFilePath = sys.argv[2]

picture_of_me = face_recognition.load_image_file(knownFilePath)
my_face_encoding = face_recognition.face_encodings(picture_of_me)
if my_face_encoding:
	print("something here")
	my_face_encoding = my_face_encoding[0]
else:
	sys.exit("my face not detected")	

# my_face_encoding now contains a universal 'encoding' of my facial features that can be compared to any other picture of a face!

unknown_picture = face_recognition.load_image_file(unknownFilePath)
unknown_face_encoding = face_recognition.face_encodings(unknown_picture)
if unknown_face_encoding:
	print("something ehre")
	unknown_face_encoding = unknown_face_encoding[0]
else:
	sys.exit("unknown face not detected")

# Now we can see the two face encodings are of the same person with `compare_faces`!

results = face_recognition.compare_faces([my_face_encoding], unknown_face_encoding)

if results[0] == True:
    print("It's a picture of me!")
else:
    results[0]
