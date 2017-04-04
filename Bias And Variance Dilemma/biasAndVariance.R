##################################################################################################################################
# This R program is used to understand Bias and Variance tradeoff.
#Name : Yash Divecha
##################################################################################################################################

#20 instances with x = [0 5] following uniform distribution
x <- seq(0,5,length.out = 20)

#Corresponding y 
y_temp <- 2 * cos(2.8 * x) + 7.5 

#Corresponding y with added noise following normal distribution N(0, 1) .
y <- 2 * cos(2.8 * x) + 7.5 + rnorm(x,0,1)

#Plotting the points (Function and Data)
par(mfrow=c(2,3))
plot(x, y_temp, main="Function and data", type="l", ylab="", xlab="")
points(x, y, pch="X")

#Creating 100 datasets with added noise
dataSet_ <- list()	#dataSet_ is a list of 100 dataSets each having 20 instances.
for(i in 1:100){	
	y_noise <- y + rnorm(x,0,1)
	dataSet_[[i]] <- c(y_noise)
	#dataSet_[[i]] <- c(y + rnorm(x,0,1))
}
#Taking the mean(average) of the dataset
output <- matrix(unlist(dataSet_), ncol = 20, byrow = TRUE)
dataSet_Avg <- colMeans(output)

#output <- do.call(rbind,dataSet_)
#dataSet_Avg <- colMeans(output)
#dataSet_Avg

##################################################################################################################################
#Computing Order 1 Polynomial Fit
plot(x,y,type="n", ylab="",xlab="",main="Order 1 Polynomial Fit", col = "black")

for(i in 1: 5){
	temp <- dataSet_[[i]]
	fit1 <- lm(temp~x)
	lines(x, predict(fit1) )
}
#Taking the mean(average) of the Polynomial Fit 1
fit1 <- lm(dataSet_Avg~x)
lines(x, predict(fit1), lty=2,col = "red")
##################################################################################################################################

#Computing Order 2 Polynomial Fit
plot(x, y, type="n", main="Order 2 Polynomial Fit", ylab="", xlab="", col="black")
for(i in 1: 5){
	
	temp <- dataSet_[[i]]
	
	#fit2 <- lm(temp ~ poly(x,2,raw = TRUE))
	fit2 <- lm(temp ~ x+ I(x^2))
	lines(x, predict(fit2))
	
	'
	xsq <- x^2
	m2 <- lm(g ~ x + xsq)
	xv <- seq(min(x), max(x), length = 20)
	yv <- predict(m2, list(x=xv,xsq=xv^2))
	lines(xv,yv,col = "green")
	'
}
#Taking the mean(average) of the Polynomial Fit 2
#fit2 <- lm(dataSet_Avg~poly(x,2,raw=TRUE))
fit2 <- lm(dataSet_Avg~x+I(x^2))
lines(x, predict(fit2), lty=2, col = "red")
##################################################################################################################################


#Computing Order 3 Polynomial Fit
plot(x, y, type="n", main="Order 3 Polynomial Fit", ylab="", xlab="", col="black")
for(i in 1: 5){
	temp <- dataSet_[[i]]	
	
	#fit3 <- lm(temp ~ poly(x,3,raw = TRUE))
	fit3 <- lm(temp ~ x+I(x^2)+I(x^3))

	lines(x, predict(fit3))
	'
	xsq = x^2
	xcub = x^3
	m3 <- lm(g ~ x + xsq+ xcub)
	xv <- seq(min(x), max(x), length = 20)
	yv <- predict(m3, list(x = xv, xsq = xv^2, xcub = xv^3))	
	lines(xv,yv,col = "blue")
	'
}
#Taking the mean(average) of the Polynomial Fit 3
#fit3 <- lm(dataSet_Avg~poly(x,3,raw=TRUE))
fit3 <- lm(dataSet_Avg ~ x + I(x^2)+I(x^3))
lines(x, predict(fit3), lty=2, col = "red")
##################################################################################################################################


#Computing Order 4 Polynomial Fit
plot(x, y, type="n", main="Order 4 Polynomial Fit", ylab="", xlab="", col="black")
for(i in 1: 5){
	temp <- dataSet_[[i]]	
	
	#fit4 <- lm(temp ~ poly(x,4,raw = TRUE))
	fit4 <- lm(temp ~ x+I(x^2)+I(x^3)+I(x^4))
	lines(x, predict(fit4))
	'
	xsq = x^2
	xcub = x^3 
	xquar = x^4
	m4 <- lm(g ~ x + xsq+ xcub + xquar)
	xv <- seq(min(x), max(x), length = 20)
	yv <- predict(m4, list(x = xv, xsq = xv^2, xcub = xv^3, xquar = xv^4))
	lines(xv,yv,col = "black")
	'
	
}
#Taking the mean(average) of the Polynomial Fit 4
#fit4 <- lm(dataSet_Avg~poly(x,4,raw=TRUE))
fit4 <- lm(dataSet_Avg~x+I(x^2)+I(x^3)+I(x^4))
lines(x, predict(fit4), lty=2, col = "red")
##################################################################################################################################


#Computing Order 5 Polynomial Fit
plot(x, y, type="n", main="Order 5 Polynomial Fit", ylab="", xlab="", col="black")
for(i in 1: 5){
	temp <- dataSet_[[i]]	
	
	#fit5 <- lm(temp ~ poly(x,5,raw = TRUE))
	fit5 <- lm(temp ~ x+I(x^2)+I(x^3)+I(x^4)+I(x^5))
	lines(x, predict(fit5))
	'
	xsq = x^2 
	xcub = x^3
	xquar = x^4
	xquin = x^5
	m5 <- lm(y ~ x + xsq+ xcub + xquar+xquin)
	xv <- seq(min(x), max(x), length = 20)
	yv <- predict(m5, list(x = xv, xsq = xv^2, xcub = xv^3, xquar = xv^4, xquin = xv^5))
	lines(xv,yv,col = "yellow")
	'
}
#Taking the mean(average) of the Polynomial Fit 5
#fit5 <- lm(dataSet_Avg~poly(x,5,raw=TRUE))
fit5 <- lm(dataSet_Avg~x+I(x^2)+I(x^3)+I(x^4)+I(x^5))
lines(x, predict(fit5), lty=2, col = "red")
##################################################################################################################################


#Bias

#This function get the Bias of Polynomial fits.
findBiasOfFit <- function(fit, y){
  bias <- mean((predict(fit) - y)^2)
  #bias <- bias/20
  bias <- sqrt(bias)
  
  return(bias)
}

BiasOrder1 <- findBiasOfFit(fit1,y)
#BiasOrder1
BiasOrder2 <- findBiasOfFit(fit2,y)
#BiasOrder2
BiasOrder3 <- findBiasOfFit(fit3,y)
#BiasOrder3
BiasOrder4 <- findBiasOfFit(fit4,y)
#BiasOrder4
BiasOrder5 <- findBiasOfFit(fit5,y)
#BiasOrder5
totalBias <- c(BiasOrder1, BiasOrder2, BiasOrder3, BiasOrder4, BiasOrder5)
#############################################################################################################################


#Variance

#This function get the variance of Polynomial fits.
findVarianceOfFit <- function(varianceOrder, dataSet_, fit){
  N <- 20
  M <- 100
  for(i in 1:100){
	  varianceOrder <- sum(varianceOrder, (( mean(dataSet_[[i]]) - predict(fit))^2))
  }
  varianceOrder <- varianceOrder /(N*M)
  return(varianceOrder)
}       
       
varianceOrder1 <- 0
varianceOrder1 <- findVarianceOfFit(varianceOrder1, dataSet_, fit1)
#varianceOrder1
varianceOrder2 <- 0
varianceOrder2 <- findVarianceOfFit(varianceOrder2, dataSet_, fit2)
#varianceOrder2
varianceOrder3 <- 0
varianceOrder3 <- findVarianceOfFit(varianceOrder3, dataSet_, fit3)
#varianceOrder3
varianceOrder4 <- 0
varianceOrder4 <- findVarianceOfFit(varianceOrder4, dataSet_, fit4)
#varianceOrder4
varianceOrder5 <- 0
varianceOrder5 <- findVarianceOfFit(varianceOrder5, dataSet_, fit5)
#varianceOrder5

totalVariance <- c(varianceOrder1, varianceOrder2, varianceOrder3, varianceOrder4, varianceOrder5)
##################################################################################################################################

#Error
error <- totalBias + totalVariance
##################################################################################################################################

#Plotting Bias, Variance and Error
xAxis <- c(1,2,3,4,5)
yAxis <- seq(0, 4, length.out=5)

par(mfrow=c(1,1))
plot(xAxis,yAxis,type="n", ylab="Error", xlab="Order",main="Bias and Variance")
legend(1, 4, legend=c("Bias", "Variance", "Error"),col=c("red", "blue", "black"),lty=1:1:1, cex=0.8)

lines(xAxis, totalBias, col="red", lty=2)
lines(xAxis, totalVariance, col="blue", lty=2)
lines(xAxis, error, col="black")