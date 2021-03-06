# CSX42: Assignment 1
## Name: Kai yi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
read the sentence from the file by Regular expression.
MetricCalculate class is to calculate the Metric.
SentenceProcess class is to deal with each sentence.
claculate the frequence of the max word using an hashMap to store the String and the frequence.Time complexcity is O(n)
claculate the longestWord is to split the text by Regular expression in word and get the most longest word.
claculate the char is to split the text by Regular expression to get String Array and filter the \n to get the length of the String array;
claculate the number of each sentence is to calculatet the number of sentence by . and using length / number of sentence.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: Feb 6th, 2020


