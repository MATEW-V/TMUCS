#Calculate and print the area of an n-sided polygon
import math 

print("Enter the amount of sides in your polygon: ")
n = int(input())
print("Enter the side length: ")
sideL = float(input())
peri = n*sideL
apoth = (sideL/(2*math.tan(math.pi/n)))
area = round((1/2)*apoth*peri)
print(area)