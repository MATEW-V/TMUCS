#Assumed floats for most bc measurements / exact polynomials, took int as celsius

#Question one
print("Input a value in Celsius to convert into Fahrenheit: ")
cels = int(input())
x = round(((int)(cels)*(9/5)+32),2)
print("Converted Fahrenheit: "+str(x))

#Question two 
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
print("Input the first side of a triangle: ")
a = float(input())
print("Input the second side of a triangle: ")
b = float(input())
print("Input the third side of a triangle: ")
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
gRatio = ((5)**0.5+1)/2
fibbie = round(((2+gRatio)/5)*gRatio**(n)+((3-gRatio)/5)*gRatio**(-n))
print("the 'n'th number of the fibonacci sequence is: "+str(fibbie))


#n=0
#print("Here is the first 10 numbers of the given formula \nThe inaccurate fibbie sequence: ")
#for i in range(10):
#    n+=1
#    fibbie = round(((2+gRatio)/5)*gRatio**(n)+((3-gRatio)/5)*gRatio**(-n)) #10 print
#    print(fibbie)
