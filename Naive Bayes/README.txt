*****************************************************************************************
Name: Yash Divecha
Topic: Naive Bayes Implementation
Programming Language : JAVA
*****************************************************************************************

To COMPILE:
 
Go to the working directory where all the java files are present of Question 7. 
Use Command: 
bingsuns2% : make
javac *.java

Additionally you can use make clean also which removes all the .class files.
bingsuns2% : make clean
rm -f *.class
*****************************************************************************************

TO RUN: 
Go to the working directory where all the java files are present. 
Use Command: 
bingsuns2% : java NaiveBayesMain <inputFileName>
Example: 
bingsuns2% java NaiveBayesMain Weather.txt
*****************************************************************************************

OUTPUT: 
P(No): 0.35714285714285715
P(Yes): 0.6428571428571429

P(Rain|Yes): 0.3333333333333333
P(Rain|No): 0.4
P(Overcast|Yes): 0.4444444444444444
P(Overcast|No): 0.0
P(Sunny|Yes): 0.2222222222222222
P(Sunny|No): 0.6

P(Mild|Yes): 0.4444444444444444
P(Mild|No): 0.4
P(Cool|Yes): 0.3333333333333333
P(Cool|No): 0.2
P(Hot|Yes): 0.2222222222222222
P(Hot|No): 0.4

P(High|Yes): 0.3333333333333333
P(High|No): 0.8
P(Normal|Yes): 0.6666666666666666
P(Normal|No): 0.2

P(Weak|Yes): 0.6666666666666666
P(Weak|No): 0.4
P(Strong|Yes): 0.3333333333333333
P(Strong|No): 0.6

Testing Data: [Rain, Cool, High, Strong]
PlayTennis = No
P(No|X): 0.013714285714285719
*****************************************************************************************
