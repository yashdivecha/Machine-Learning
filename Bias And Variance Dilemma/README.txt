-----------------------------------------------------------------------------------------------------------------------------------
Subject: Introduction to Machine Learning.
Topic: BIAS and VARIANCE DILEMMA
Programming Language : R 
Name : Yash Divecha
-----------------------------------------------------------------------------------------------------------------------------------
This tar files contains the following files: 

README.txt : This file gives information on how to run the program.
biasAndVariance.R: This is the R program used to understand the Bias and Variance Tradeoff(Dilemma)
Sample Output File has been provided:
1. Rplots_sample_output.pdf
2. Rplots_sample_output1.pdf
-----------------------------------------------------------------------------------------------------------------------------------

How to Run R Program: 
remote04:~/ML/biasAndVariance> Rscript biasAndVariance.R

On running the program, automatically "Rplots.pdf" will be created which contains the necessary graphs. 
-----------------------------------------------------------------------------------------------------------------------------------

Some Observations.

(a) Plotted bias, variance, and error for polynomials of order 1 to 5

(b) As the order increases, 
1. VARIANCE increases
2. BIAS decreases.

Order 1 has the highest BIAS, Order 5 has the lowest BIAS.
Order 1 has the lowest VARIANCE, Order 5 has the highest VARIANCE.

Hence we can say, if one thing increases other thing decreases.
This is called Bias-Variance Dilemma
 
Considering the x to be randomly generated, we can get different graphs.
Minimal error is in order 3 polynomial fit

-----------------------------------------------------------------------------------------------------------------------------------