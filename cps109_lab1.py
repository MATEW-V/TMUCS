#Question one
print("Input a value in Celsius to convert into Fahrenheit: ")
celc = input()
x = round(((int)(celc)*(9/5)+32),2)
print("Converted Fahrenheit: "+str(x))

#Question two
print("Input the first value: ")
x = int(input())
print("Input the second value: ")
y = int(input())
print("Input the third value: ")
z = int(input())
root = format(((-y+(y**2-4*x*z)**0.5)/2*x),'.2f')
root2 = format(((-y-(y**2-4*x*z)**0.5)/2*x),'.2f')
print("the roots are: "+str(root)+" "+str(root2))

#Question three
