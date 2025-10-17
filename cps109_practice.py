# 1. Login-In

# Make a Login-In system. Inside of an infinite loop, prompt the user for a text input. 
# If the user types “check in”, ask for a name to add to a database of names and add the name. 
# If the user types “check out”, ask for a name to remove from the database of names and remove the name. 
# If the user types "who", display all of the names
# If the user types “end”, display the text “bye bye” and end the program.
# Assume the user only inputs valid input commands, and they only check out names that are in the database.
# Bonus: if the user enters an invalid command or name, print an appropriate message

def login():
    data=[]
    while (True):
        userin=input("Enter smth man: ")
        if userin == "end":
            print("bye")
            break
        elif userin=="check in":
            name=input("wahts yo name: ")
            if name in data:
                print("sm1 got yo name already man")
            else:
                data.append(name)
                print('welc')
        elif userin=="check out":
            name=input("wahts yo name: ")
            if name not in data:
                print("nah man ion see it")
            else:
                data.remove(name)
                print("ight removed")
        elif userin=="who":
            print(data)
        else:
            print("cmon be proper i dont undestand")
#login()

# 2. Magic Numbers

# Write a program that takes a list of integers as input and return a new version of the list based
# of conditions below. Note: we are basing our actions on the original list values, not the modified
# values that we make along the way.

# Even numbers at an even index are "true even numbers". Replace the value with the sum of all the previous 
# true even numbers not including the current true even number.
# Odd numbers at odd indexes are "true odd numbers". Replace the value with the sum of all the previous true
# odd numbers, including the current odd number.
# Even numbers at an odd index and odd numbers at an even index are "anomalies". Replace the value with 
# the square of the value.

# Assume 0 is an even index

# Example:
# Input: [12, 5, 22, 15, 7, 4, 4]
# Output: [0, 5, 12, 20, 49, 16, 34]

# Input: [4, 4, 4, 4, 3, 3, 3, 3]
# Output: [0, 16, 4, 16, 9, 3, 9, 6]
def magic_numbers(lst):
    true_even = 0
    true_odd = 0
    result = []
    for i in range(len(lst)):
        value=lst[i]
        if value%2==0 and i%2==0:
            result.append(true_even)
            true_even+=value
        elif value%2!=0 and i%2!=0:
            true_odd+=value
            result.append(true_odd)
        else:
            result.append(value**2)
    return(result)
# print(magic_numbers([12, 5, 22, 15, 7, 4, 4])) 

# 3. Greater half

# Write a function that accepts an integer input. The integer input will always have an even number of
# digits. Split the integer into two halves (first half of the digits and second half of the digits).
# Return 1 if the sum of the digits in the first half is greater than the sum of the digits in the second
# half. Return 2 if the second sum is greater than the first. Return 0 if the sums are equal.

# Example:
# Input: 123456
# Output: 2

# Input: 53
# Output: 1

# Input: 91827364
# Output: 0

def greaterhalf(n):
    h1,h2=[],[]
    intlist = list(map(int,str(n)))
    for i in range(len(intlist)):
        if i<(len(intlist)/2):
            h1.append(intlist[i])
        else:
            h2.append(intlist[i])
    if sum(h1)==sum(h2):
        return(0)
    elif sum(h1)>sum(h2):
        return(1)
    else:
        return(2)

# print(greaterhalf(1010))

# 4. Count Letters

# Given a string and a character, output the number of 
# times that the character appears in the string

# 5. List Generation

# The following questions involve receiving a sequence as 
# input and producing a new resulting list following some 
# desired behaviour. They have been grouped together as a 
# way to practice iterating through sequences - if list 
# comprehension is included in your test outline, try solving 
# some of these questions using list comprehension instead
# of a large structure of code


# A. Given a list of integers, return the integers that are 
# both odd and multiples of 3.

# list_gen_a([3,6,9,12,5,4])  >>  [3,9]


# B. Given a string, produce a list of characters that are 
# between the letters "a" and "m"

# list_gen_b("Hello")  >>  ["e", "l", "l"]


# C. Create a function called str_add2(x) that takes in a 
# string value, converts it to an integer, adds 2, converts
# it back to a string and returns the resulting value. Given
# a list of numbers represented as strings (for example, "12", "-4", "22"), 
# use the str_add2 function to produce a new list of String values with their 
# stored value increased by 2.

# list_gen_c(["12", "-4", "23", "99", "-11"])  >>  ["14, "-2", "25", "101", "-9]

# 6. Create a function called max_many() that prompts the user 
# to input an integer value, representing the number of values 
# that they are going to enter. Repeatedly prompt the user for 
# integers according to their first input, and store the given 
# values. After receiving all the values from the user, return
# the largest value received from the user. 
# Hint: is there a function we can use to find the largest value
# in a collection? Try solving this with and without that function.

# How many values? >6
# > 18
# > 4
# > 20
# > -100
# > 5
# > 7

# >> 20


# 7. Angles (Long one, some hints at the very end)

# Prompt the user for the angles of a geometric shape one at a time until the user enters -1.

# Given the angles, determine if this geometric shape can exist based on the number of sides.
# The sum of angles should equal (n - 2) * 180, where n is the number of angles. If the
# geometric shape is NOT valid, print a message to the user saying that the angles are invalid.

# If the angles describe a regular polygon, print a message to the user. A regular polygon is
# a shape where all angles are equal (and all sides are equal, but we don't care about side length).

# If the given angles describe a shape that has obtuse angle (larger than 90 degrees but less than
# 180 degrees), print a message to the user that the shape contains an obtuse angle.

# If the shape is a triangle, and the angles describe a right angled-triangle, print a message
# to the user that the shape is a right angled triangle.

# There are many ways to do each section of this task. Try implementing this problem using a list
# to store the given input values, then redo this example without using a list - this will be harder
# but will require a totally different perspective and approach to the problem. Hints are available
# at the bottom of the document for implementing without a list

# ----
# 90
# 90
# 90
# 90
# -1
# >Regular Polygon
# ----
# 15
# 95
# 70
# -1
# >Irregular Polygon
# >Obtuse Angle
# ----
# 135
# 135
# 135
# 135
# 135
# 135
# 135
# 135
# -1
# >Regular Polygon
# >Obtuse Angle 
# ----
# 30
# 60
# 90
# -1
# >Irregular Polygon
# >Right Triangle

# 8. Fraction Addition

# Make a function that takes in 5 values: Numerator_A, Denominator_A,
# Numberator_B, Denominator_B, and Op. The Numerator and Denominator
# pairs represent two fractions, and Op is a char representing the operation
# you will perform on the fractions. Op can either be '+', '-', '*',
# which are addition, subtraction, and multiplication respectively. 

# When doing addition or subtraction, you must find the common 
# denominator before trying to add or subtract the numerator values.
# When multiplying fractions, you multiply the two numerators to get
# the new numerator, and multiply the two denominators to get the new
# denominator. See the 8_FractionHint.png for more information.

# After doing the given operation, print out the numerator, then
# "---" on the next line, and the denominator on the next line so it
# looks like a fraction. Don't worry about simplifying the fraction.

# Example:
# fractionAddition(3,5,2,3,"+") 
# 19
# ---
# 15

# fractionAddition(2,3,3,5,"-") 
# 1
# ---
# 15

# fractionAddition(4,7,2,6,"*") 
# 4
# ---
# 21

# X. Palindrome

# Given a string, determine if it is a palindrome or not. 
# Palindromes read the same backwards or forwards.
# For the purpose of this function, assume there are no spaces
# in the given string. For a bonus, make your code
# ignore spaces and only consider letters and numbers.

# racecar - True
# apple - False
# asdfghjklplkjhgfdsa - True

# Bonus:
# race car - True
# apple - False
# asd fghjklplk jhgfds a - True

# 10. Prime Numbers

# Print out all the prime numbers between 1 and n (inclusive),
# where n is the input to your function


