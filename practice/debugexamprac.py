# Alvin and the Chipmunks (Theodore and Simon) need help figuring out the permissions on some important files. 
# Write a function that decodes a three digit number and returns a list of strings stating the permissions of each chipmunk. 
# The first digit represents the permissions for Theodore, the second digit represents the permissions for Simon, and the third digit represents the permissions for Alvin.
# Ex:
# 035 -> ['Theodore has no permission.', 'Simon has write and execute permissions.', 'Alvin has read and execute permissions.']

# Use the following for reference 
# Decimal | Binary | Permission
# ------------------------------
#       0 | (000) | No permission.
#       1 | (001) | Execute permission.
#       2 | (010) | Write permission.
#       3 | (011) | Write and execute permissions.
#       4 | (100) | Read permission.
#       5 | (101) | Read and execute permissions.
#       6 | (110) | Read and write permissions.
#       7 | (111) | Read, write, and execute permissions.

def decoder(permissions):
    # Binary representation of numbers 0 to 7 and their associated permission
    decoder = {'000': 'no permission',
    '001': 'execute permission',
    '010': 'write permission',
    '011': "write and execute permissions",
    '100': 'read permission',
    '101': "read and execute permissions",
    '110': 'read and write permissions',
    '111': 'read, write, and execute permissions'}

    decdecoder = {"0":"000", "1":"001","2":"010","3":"011","4":"100","5":"101","6":"110","7":"111"}
    res=[]
    for x,i in enumerate(str(permissions)):
        if i in decdecoder and x==0:
            res.append("Theodore has "+decoder.get(decdecoder.get(i))+".")
        if i in decdecoder and x==1:
            res.append("Simon has "+decoder.get(decdecoder.get(i))+".")
        if i in decdecoder and x==2:
            res.append("Alvin has "+decoder.get(decdecoder.get(i))+".")
    return res
# --------------------------------------------------------------
# Testing
# --------------------------------------------------------------
def test(answer, expected):
  if (answer == expected):
    result = "\033[92mPASS\033[0m"
  else:
    result = "\033[91mFAIL\033[0m"
  print("ANS:", answer)
  print("Expected:", expected)
  print(result, "\n")

test(decoder(664),['Theodore has read and write permissions.', 'Simon has read and write permissions.', 'Alvin has read permission.'])
test(decoder(700),['Theodore has read, write, and execute permissions.', 'Simon has no permission.', 'Alvin has no permission.'])
test(decoder(321),['Theodore has write and execute permissions.', 'Simon has write permission.', 'Alvin has execute permission.'])


# There was an error in the banking system and now all names and numbers are backwards and jumbled together. 
# Create a function that takes in a list of strings and returns a dictionary with client names as the key and credit card number as the value. 
# Each string in the original list has a client name and number in reverse order all jumbled together.
# Ex:
# ['r4e011pooCn25790od8695le774hS'] -> {'Sheldon Cooper' : '4775968097521104'}

def organize(jumble):
    result = {}
    
    for string in jumble:
        reversed_string = string[::-1]
        
        name = "".join([x for x in reversed_string if x.isalpha()])
        cc = "".join([x for x in reversed_string if x.isdigit()])
        
        for j in range(1, len(name)):
            if name[j].isupper():
                name = name[:j] + " " + name[j:]
                break  
        result[name] = cc
    
    return result
# --------------------------------------------------------------
# Testing
# --------------------------------------------------------------
def test(answer, expected):
  if (answer == expected):
    result = "\033[92mPASS\033[0m"
  else:
    result = "\033[91mFAIL\033[0m"
  print("ANS:", answer)
  print("Expected:", expected)
  print(result, "\n") 

jumble = ['r4e011pooCn25790od8695le774hS']
database = {'Sheldon Cooper' : '4775968097521104'}
test( organize(jumble), database )
  
jumble = ['2r45e4tt5o466P561yrr689aH37','y652of30633laM466oc99ar055D','r3e3g5n81arGe5n293oim53reH23933', '317yel972sa767eW3409no439R' ]
database = {'Harry Potter': '7398616566454542','Draco Malfoy': '5509966433603256','Hermione Granger': '3393235392518533','Ron Weasley': '9349043767279713'}
test( organize(jumble), database )

jumble =['no39sn293hoJ930eny792aw673D65','s398dl18on69yeR3365n028ay29R','40a7y324rA7201u4t129iR01', 't406o6495d112aG888laG572']
database = {'Dwayne Johnson': '5637629703939293','Ryan Reynolds': '9282056339681893','Ritu Arya': '1092141027423704','Gal Gadot': '2758882115946604'}
test( organize(jumble), database )

# # The Nike Store had a huge sale and now the inventory count is a mess. 
# # It's your job to help them figure out how many XS, S, M, L, and XL they have.
# # Given a string return a dictonary with a count of many XS, S, M, L, and XL there are.
# #
# # Ex:
# # 'SMLXL' -> {'XS': 0, 'S':1,'M':1,'L':1,'XL':1}

def takeInventory(clothes):
    s=clothes.replace("XS","").count("S")
    l=clothes.replace("XL","").count("L")
    return({'XS':clothes.count("XS"),"S":s,"M":clothes.count("M"),"L":l,"XL":clothes.count("XL")})


# --------------------------------------------------------------
# Testing
# --------------------------------------------------------------
def test(answer, expected):
  if (answer == expected):
    result = "\033[92mPASS\033[0m"
  else:
    result = "\033[91mFAIL\033[0m"
  print("ANS:", answer, "Expected:", expected)
  print(result, "\n")


inventory = {'XS' : 0, 'S':1,'M':1,'L':1, 'XL':1}
test( takeInventory('SMLXL'), inventory)
  
inventory = {'XS' : 0, 'S':0,'M':0,'L':0, 'XL':0}
test( takeInventory(''), inventory)

inventory = {'XS' : 0, 'S':0,'M':1,'L':0, 'XL':0}
test( takeInventory('M'), inventory)

inventory = {'XS' : 2, 'S':3,'M':5,'L':1, 'XL':2}
test( takeInventory('XSSSMXLLMSXLXSMMM'), inventory)

inventory = {'XS' : 2, 'S':1,'M':3,'L':2, 'XL':1}
test( takeInventory('LMXSSMMXLLXS'), inventory)

def calculate_price(prices):
    # You are writing a program to calculate the total price of all
    # items in your shopping cart, provided as a list of Strings.
    # The prices are expected to be provided in the following format,
    # "$12.34", where the prices range from $0 to $150 inclusive.

    # Using exception handling, determine the final cost of the
    # shopping cart. If an element cannot be properly added to the total
    # cost, print a message to the user and continue processing
    # the remaining items. Your function should return a Float
    # representing the final cost.
    res=[]
    for i in prices:
        try:
            if "$" in i:
                i = i.replace("$","",1)
                i = float(i)
                res.append(i)
        except:
            pass
    return sum(res)

# --------------------------------------------------------------
# The Testing
# --------------------------------------------------------------
def test(answer, expected):
    if (answer == expected):
        result = "\033[92mPASS\033[0m"
    else:
        result = "\033[91mFAIL\033[0m"
    print("ANS:", answer, "Expected:", expected)
    print(result, "\n")
		

list1 = ["$32.56", "$0.40", "money", "$four", "$1.54", "5.49", "$104.5"]
test(calculate_price(list1), 139.0)

list2 = ["$$32", "$23.29*", "$40..00", "$20", "$14.4"]
test(calculate_price(list2), 34.4)

list3 = ["$123.45", "$0", "$", "$40.9"]
test(calculate_price(list3), 164.35)
# --------------------------------------------------------------
# Inputs
# --------------------------------------------------------------
input_1 = " Hello    " # " Hello", " Hello----"
input_2 = " There are many    spaces " # " There are many    spaces", " There are many    spaces-"
input_3 = "Nospace" # "Nospace", "Nospace"
input_4 = "     beginning" # "     beginning", "     beginning"
input_5 = "           b       " # "           b", "           b-------"
input_6 = " --" # " --", " --"
def two_strings(instr):
    # First string
    first_string = instr.rstrip()
    
    # Second string
    trailing_spaces = len(instr) - len(instr.rstrip())
    second_string = instr.rstrip() + '-' * trailing_spaces
    
    print(first_string)
    print(second_string)
two_strings(input_1)
two_strings(input_2)
two_strings(input_3)
two_strings(input_4)
two_strings(input_5)

def digit_diff(nums) :
    '''
    Given a tuple of two ints, calculate the sum of the absolute
    difference between the corresponding digits, return
    the value. 

    Example:
    num1 = 1234   num2 = 9876
    answer = |1-9| + |2-8| + |3-7| + |4-6|
           = (8)   + (6)   + (4)   + (2)
           = 20
    '''
    x=0
    con = list(map(str,nums))
    num1=list(con[0])
    num2=list(con[1])
    for i in range(len(num1)):
        x+=abs(int(num1[i])-int(num2[i]))
    return x
# --------------------------------------------------------------
# Inputs
# --------------------------------------------------------------
input_1 = (1234, 9876)
input_2 = (4701050830, 4701050831)
input_3 = (34**12, 18**15)
input_4 = (7,5)
input_5 = (65555, 10000)
input_6 = (1234567890, 2345678901)

# --------------------------------------------------------------
# Testing
# --------------------------------------------------------------
def test(answer, expected):
  if (answer == expected):
    result = "\033[92mPASS\033[0m"
  else:
    result = "\033[91mFAIL\033[0m"
  print("ANS:", answer, "Expected:", expected)
  print(result, "\n")

# Test Cases
test(digit_diff(input_1),20)
test(digit_diff(input_2),1)
test(digit_diff(input_3),59)
test(digit_diff(input_4),2)
test(digit_diff(input_5),25)
test(digit_diff(input_6),18)

# This file contains a collection of tasks
# that require you to use a 2D list

# Depending on timing, one of these examples
# may be done live during the review session,
# and the others can be used as practice 

# 1. Find the row with the largest sum
# 2. Find the coordinate of a specific value
# 3. Find the largest value in the 2D list
#    (and its coordinate)
# 4. Given a 2D list, replace each sublist with
#    the sum of its elements
# 5. Find the row with the most elements in it
# 6. Find the column with the largest sum (assume
#    all rows have the same length)

# Here is a sample input that you can use to test
# your functions. It's important to note that your
# functions should work with a list with any dimensions
# and any values.

sampleList = [ [5, 6, 10, 1],       # row 0
               [8, 13, -4, 2],      # row 1
               [9, 10, 11, 7],
               [9, 10, 10, 8]]     

def greatestRow(myList):
    """
    Given a 2D list as the input, return the
    row number whose sum is the largest. If two
    rows have the same sum, return the lower row
    number. sampleList's greatest row would be
    row 2.
    """
    cke=[]
    for i in myList:
        cke.append(sum(i))
    for y,x in enumerate(cke):
        if x == max(cke):
            return myList[y]
print(greatestRow(sampleList))

def findCoord(myList, value):
    """
    Given a 2D list and a value to search for, return
    a tuple containing the row and column number where
    the item first appears in the list. If there are
    multiple instances, you should return the coordinate
    with the smaller row number (if row numbers are the
    same, return the coords with the smaller column number).
    findCoord(sampleList, -4) = (1, 2)
    """
    for x,i in enumerate(myList):
        if value in i:
            for y,j in enumerate(i):
                if j == value:
                    return (x,y)
print(findCoord(sampleList,11))                    

def maxValue(myList):
    """
    Given a 2D list, return a tuple containing the largest
    value in the list, its row number, and its column number. 
    Would your code still work if the list only
    contained negative values? If not, you should modify
    your code. 
    maxValue(sampleList) = (13, 1, 1)
    """
    value=max([x for sublist in myList for x in sublist])
    for x,i in enumerate(myList):
        if value in i:
            for y,j in enumerate(i):
                if j == value:
                    return (value,x,y)
print(maxValue(sampleList))

def condenseList(myList):
    """
    Given a 2D list, replace each sublist with an integer
    representing the sum of the values in the sublist.
    Note: you should be modifying the original list, not
    making a new list. Be sure to test this function separately
    from your other functions to make sure your modifications don't
    create unexpected outputs for other functions using the list.
    condenseList(sampleList) = [22, 19, 37]
    """
    pass

def longestRow(myList):
    """
    Given a 2D list, return the row number of the sublist
    with the most elements in it. If multiple sublists have
    the same number of elements, return the lower index.
    longestRow(sampleList) = 0
    You should probably make your own test case for this one
    """
    pass

def greatestColumn(myList):
    """
    Given a 2D list where all the rows have the same length,
    return the column number with the greatest sum. If two
    columns have the same sum, return the column with the
    smaller column number. How would this function be 
    different from the greatestRow function?
    greatestColumn(myList) = 1
    """
    pass

# def drop_char(in_str, char) :
#     '''
#     Remove every occurence of a character from the given string

#     Example: 'apple pie' -> 'ale ie'

#     Multiple ways to do this task:
#     1. Build new word from valid chars, one at a time
#     2. Upon finding char, concatenate around it
#        'apple pie' -> 'a' + 'ple pie' = 'aple pie'
#        'aple pie' -> 'a' + 'le pie' = 'ale pie' ...
#     3. Use string method to split at char, rejoin
#     4. Turn into list, detect instances of char, remove each
#     5. Use all-in-one tool - string.replace('target','newchar')
#     '''

#     pass

# # --------------------------------------------------------------
# # Inputs
# # --------------------------------------------------------------
# phrase_1 = "abababababababababa" # 'a'
# phrase_2 = "P l e a s e rem ove spaces from this." # ' '
# phrase_3 = "You. don't. use. periods. like. this." # '.'
# phrase_4 = "I really don't like the letter i" # 'i'
# phrase_5 = "    oh     " # ' '
# phrase_6 = "qwertyqwertyqwerty" # 'z'
# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------
# def test(answer, expected):
#   if (answer == expected):
#     result = "\033[92mPASS\033[0m"
#   else:
#     result = "\033[91mFAIL\033[0m"
#   print("ANS:", answer, "Expected:", expected)
#   print(result, "\n")

# test(drop_char(phrase_1,'a'),'bbbbbbbbb')
# test(drop_char(phrase_2,' '),'Pleaseremovespacesfromthis.')
# test(drop_char(phrase_3, '.'),"You don't use periods like this")
# test(drop_char(phrase_4, 'i'),"I really don't lke the letter ")
# test(drop_char(phrase_5,' '),"oh")
# test(drop_char(phrase_6, 'z'),'qwertyqwertyqwerty')

# def tidal_waves(num_waves) :
#     '''
#     Given the number of waves, use the print method to produce
#     a command line image of surfers riding waves.
#     The water will consist of asterisks *. Each wave starts as
#     a single *, and the amount increases up to the wave number.
#     A surfer should appear at the peak of each wave
    
#     (>-|o represents a surfer

#     ex: tidal_waves(4)

#     *(>-|o     <-- first wave, only 1 water
#     *          <-- start of second wave
#     **(>-|o    <-- peak of second wave
#     *          <-- start of third wave
#     **
#     ***(>-|o   <-- peak of third wave
#     *          <-- start of third wave
#     **
#     ***
#     ****(>-|o  <-- peak of fourth wave
#     '''
#     pass   

# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------

# tidal_waves(5)



# #RECURSIOIN
# def directional_max(numbers) :
#     ''' 
#     Given a list of numbers, recursively calculate the number of directional
#     maximums. A directional maximum is a number that is greater than all numbers
#     within a list either to the left or to the right of that number. Numbers at
#     the beginning of the list are considered left maximum because there are no
#     numbers to the left of it. Numbers at the end of the list are considered right
#     maximum because there are no numbers to the right of it.
#     Create a function that determines the total number of directional maximum numbers - 
#     i.e. add the number of left maximums to the number of right maximums - and returns
#     the total
    
#     Supporting functions:
#     Create a left_max() and right_max() functions that take a list as input.
#     For the left_max() function, if the last element is greater than the maximum
#     value to the left of it, increase the quantity of left maximums and update the
#     maximum value. The left_max() function returns 2 values - the number of left
#     maximums in the list and the maximum value in the list.

#     Example:
#     > left_max([2])
#     returns (1,2) < only one value, it is a left max; the max value is 2
#     > left_max([2,5,3,7])
#     The current maximum value is 5, and there are currently 2 left maximums.
#     Compares 7 to the maximum value 5 - 7 is the new maximum value, now there are 3 left maximums.
#     returns (3,7)

#     The right_max() function behaves the same way, but compares the first value in the list
#     to the values to the right of it.

#     Example:
#     directional_max( [4, 6, 2, 7] )

#     left maximums:    *  *     *
#                      [4, 6, 2, 7]
#     right maximums:            *
#     There are 3 left maximums and 1 right maximum, therefore the total number of
#     directional maximums is 4
#     '''
    
#     return

# def left_max(numbers):
#     return

# def right_max(numbers):
#     return
        
# # --------------------------------------------------------------
# # Inputs
# # --------------------------------------------------------------
# input_1 = [1,2,3,4,5,6]
# input_2 = [20, 21, 5, 4, 3, 21, 22]
# input_3 = [20, 21, 5, 4, 3, 23, 22]
# input_4 = [7, 9, 11, 13, 8, 6, 3]
# input_5 = [50, 1, 1, 1, 0, 2, 1, 50]
# input_6 = [50, 1, 1, 1, 55, 2, 1, 50]

# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------
# def test(answer, expected):
#   if (answer == expected):
#     result = "\033[92mPASS\033[0m"
#   else:
#     result = "\033[91mFAIL\033[0m"
#   print("ANS:", answer, "Expected:", expected)
#   print(result, "\n")

# test(directional_max(input_1),7)
# test(directional_max(input_2),4)
# test(directional_max(input_3),5)
# test(directional_max(input_4),8)
# test(directional_max(input_5),2)
# test(directional_max(input_6),4)

# def count_steps(distances) :
#     ''' 
#     let distances be an input list [x,y,z,...,n]
#     A runner is doing exercises, sprinting back and forth between multiple lines.
#     Starting at their starting position, they run x steps to get to the starting pylon,
#     then run x steps back to their starting position. Then the runner runs to the
#     second pylon, which is x + y steps away, then back to the starting position,
#     running another x + y steps. The runner continues this pattern until they have
#     reached the final pylon - note that they do not return to the starting position
#     upon reaching the final pylon.
#     Create a program that receives a list input containing the distances between each
#     pylon (x is the distance from the starting position to the first pylon) and outputs
#     the total number of steps taken by the runner throughout the whole exercise. Solve this
#     program recursively.
#     '''

#     return 0

        
# # --------------------------------------------------------------
# # Inputs
# # --------------------------------------------------------------
# input_1 = [1,2,3,4,5,6]
# input_2 = [20, 21, 5, 4, 3, 21, 22]
# input_3 = [20, 21, 5, 4, 3, 23, 22]
# input_4 = [7, 9, 11, 13, 8, 6, 3]
# input_5 = [50, 1, 1, 1, 0, 2, 1, 50]
# input_6 = [50, 1, 1, 1, 55, 2, 1, 50]

# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------
# def test(answer, expected):
#   if (answer == expected):
#     result = "\033[92mPASS\033[0m"
#   else:
#     result = "\033[91mFAIL\033[0m"
#   print("ANS:", answer, "Expected:", expected)
#   print(result, "\n")

# test(count_steps(input_1),91)
# test(count_steps(input_2),664)
# test(count_steps(input_3),670)
# test(count_steps(input_4),441)
# test(count_steps(input_5),846)
# test(count_steps(input_6),1231)

# def decrease_distance(Joe_step, Mark_step):
#   ''' Joe and Mark are on a staircase, and they are both on different steps.
#   Joe is on a lower step than Mark.
#   Joe and Mark love adding numbers, and they want to calculate a number.
#   On each step, Joe and Mark want to add the step number that each of them are
#   on, and add the number of stairs between them. Joe will go up to the next step, 
#   Mark will go down to the previous step, and they will continue adding numbers.
#   This continues until they are on the same step, or they are standing one step apart.
#   Calculate the total sum from this calculation and return the value.

#   Ex: Joe_step = 4, Mark_step = 10
#   4,10 -> 4 + 10 + (10-4) = 20
#   5,9  -> 5 + 9 + (9-5) = 18
#   6,8  -> 6 + 8 + (8-6) = 16
#   7,7  STOP     20+18+16 = 54

#   Ex: Joe_step = 4, Mark_step = 9
#   4,9 -> 4 + 9 + (9-4) = 18
#   5,8  -> 5 + 8 + (8-5) = 16
#   6,7  STOP     18+16 = 34
  
  
#   '''

# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------
# def test(answer, expected):
#   if (answer == expected):
#     result = "\033[92mPASS\033[0m"
#   else:
#     result = "\033[91mFAIL\033[0m"
#   print("ANS:", answer, "Expected:", expected)
#   print(result, "\n")

# test(decrease_distance(4,10), 54)
# test(decrease_distance(4,9), 34)
# test(decrease_distance(21,22), 0)
# test(decrease_distance(22,22), 0)
# test(decrease_distance(51,64), 738)


# """

#     The Collatz Sequence is a series of numbers that follows a certain
#     function to determine what the next number in the sequence is.
#     Starting with any positive integer, the sequence eventually reaches
#     1, and the sequence stops.
    
#     If the current value n is even, the next number in the sequence is n/2
#     If the current value n is odd, the next number in the sequence is 3n+1
    
#     Example:
#         6  ->  3  ->  10  ->  5  -> 16  ->  8  ->  4  ->  2  ->  1
#           even   odd     even   odd   even    even   even   even 
        
#     Create a recursive function that returns the number of steps required
#     to reach the value 1 from your given value. For example, given the
#     number 6, your function should output 8, as it takes 8 operations
#     to reach the value 1.
    
#     To debug your code, consider adding a print statement to show your
#     current sequence value
    
# """

# def collatz_steps(s):
#     pass

# ## Testing
# print("It took", collatz_steps(6), "steps starting from 6, expected 8 steps.")
# print("It took", collatz_steps(10), "steps starting from 10, expected 6 steps.")
# print("It took", collatz_steps(11), "steps starting from 11, expected 14 steps.")
# print("It took", collatz_steps(4), "steps starting from 4, expected 2 steps.")


# '''
#     Create a recursive function called "countVowels" that takes a 
#     lowercase string as input. Your function should return the number
#     of vowels in the string.
    
#     Knowing how this function should behave, create your own test plan.
#     Create some sample inputs and compare the results to the expected output.
    
#     Example:
#         countVowels("Hello world")   should output 3 
#                      ^   ^  ^
# '''

# def countVowels(text):
#     pass


# # Test your code below:

# """
# Flatten a nested list (list that contains other lists)

# Ex: flatten([1, [2, [3, 4], 5], 6]) --> [1, 2, 3, 4, 5, 6]
# """

# def flatten(nested):
#         pass
        
# # --------------------------------------------------------------
# # Testing
# # --------------------------------------------------------------
# def test(answer, expected):
#   if (answer == expected):
#     result = "\033[92mPASS\033[0m"
#   else:
#     result = "\033[91mFAIL\033[0m"
#   print("ANS:", answer, "Expected:", expected)
#   print(result, "\n")


# test( flatten([1, [2, [3, 4], 5], 6]), [1, 2, 3, 4, 5, 6])
# test( flatten([[[4, [4, 2]], 2, [[4, []]]]]), [4, 4, 2, 2, 4])
# test( flatten([[5, 6, 7], [2, [3, 4], 1, 3], [[1, 5, 3], 4, 5]]), [5, 6, 7, 2, 3, 4, 1, 3, 1, 5, 3, 4, 5])
# test( flatten([]), [])
