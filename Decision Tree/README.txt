*****************************************************************************************
Name: Yash Divecha
Topic: Decision Tree Implementation
Programming Language : JAVA
*****************************************************************************************

To COMPILE:
 
Go to the working directory where all the java files are present of Question 6. 
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
bingsuns2% : java DecisionTreeMain <inputFileName>
Example: 
bingsuns2% java DecisionTreeMain Weather.txt
*****************************************************************************************

OUTPUT: 
Entropy E(S): 0.9402859586706311

Information Gain G(S,Outlook) : 0.24674981977443933
Gain Ratio [Outlook] : 0.15642756242117528

Information Gain G(S,Temperature) : 0.02922256565895487
Gain Ratio [Temperature] : 0.018772646222418813

Information Gain G(S,Humidity) : 0.15183550136234159
Gain Ratio [Humidity] : 0.15183550136234159

Information Gain G(S,Wind) : 0.04812703040826949
Gain Ratio [Wind] : 0.04884861551152082

Best Attribute for the Root node is "Outlook"
*****************************************************************************************
