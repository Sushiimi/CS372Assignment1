# Ian Johnson -- 2/7/2018 -- CS372 Algorithms
# makefile to compile and test algotesting.java program
# use "make runwfile" to run with testnumbers file
# use "make run" to run and allow user input
all: compile

compile:
	javac algotesting.java

run:
	java algotesting

runwfile:
	java algotesting < testnumbersit 