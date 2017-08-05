try:
  execfile('whatever.py')
except SystemExit:
  print "sys.exit was called but I'm proceeding anyway (so there!-)."
print "so I'll print this, etc, etc"

#this script will call all combos of oneRun. Need try and catch block to stop exec of this script 
#if oneRun encounters an error and exits
