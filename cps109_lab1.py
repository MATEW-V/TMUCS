#Assumed floats for most bc measurements / exact polynomials, took int as celsius

#Question one
print("Input a value in Celsius to convert into Fahrenheit: ")
celc = int(input())
x = round(((int)(celc)*(9/5)+32),2)
print("Converted Fahrenheit: "+str(x))

#Question two //fix ts to not give cmplex
print("Input the first polynomial value: ")
x = float(input())
print("Input the second polynomial value: ")
y = float(input())
print("Input the third polynomial value: ")
z = float(input())
root = format(((-y+(y**2-4*x*z)**0.5)/(2*x)),'.2f')
root2 = format(((-y-(y**2-4*x*z)**0.5)/(2*x)),'.2f')
print("the roots are: "+root+", "+root2)

#Question three
print("Input the first side: ")
a = float(input())
print("Input the second side: ")
b = float(input())
print("Input the third side: ")
c = float(input())
print(a<=(b+c) and b<=(a+c) and c<=(a+b))

#Question 4
print("Enter a side length for a pentagon: ")
s = float(input())
area = (1/4)*((5*(5+2*(5)**0.5))**0.5)*s**2
print("the area of your pentagon is: "+str(round((area),2)))

#Question 5
print("Give me a number for the fibonacci sequence: ")
n = int(input())
fibbie = 1
gRatio = 2