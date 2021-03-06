# CSX42: Assignment 3
## Name:  Kai yi, Yi Shang Hu

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in numberPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile primeDetector/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile primeDetector/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Use the below command to run the program.
```commandline run server
1.cd primeDetector/src/BUILD/classes
2.java primeDetector.PersisterService.PersisterService -portNumber
```
```commandline run client
1.cd primeDetector/src/BUILD/classes
2.java primeDetector.driver.Driver
-inputFilePath
-numThreads
-capacity
-localhost
-port
-debugValue
```
## OutPut File:

```
generated in primeDetector/src/BUILD/classes
```
-----------------------------------------------------------------------
## Description:
Using thread pool to borrow threads and use therads to poll number and depends is prime. Then send to server and persist.

using  arraylist to store the  value, when the capacity is full wait(), when is not full notifyAll();

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"We have done this assignment completely on my own team. We have not copied
it, nor have We given my solution to anyone else. We understand that if
We are involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: March,29,2020


