# --------------------------------------------------------------
# CODING PROBLEMS: 
# --------------------------------------------------------------

'''

Fill in the functions below according to their descriptions. Test
your code by running the file "midterm_tests.py"

Make sure your code compiles before you finish the test, do NOT 
leave syntax errors in your code! This is VERY important.

You don't need to submit on D2L. Just save your code locally. Be
sure to fill in your full name and email below:

FULL NAME: <your name here>
TMU EMAIL: <your email here>

'''

# Q1) 
def roman_to_arabic(rn):
    '''
    rn is a string representing a roman numeral. Your program should convert
    this number to an arabic base-10 integer, and return it. Your function
    only has to work for first 10 roman numerals. If rn is not one of the first
    10 numerals, return None. The first 10 roman numerals are given below:

    I    = 1
    II   = 2
    III  = 3
    IV   = 4
    V    = 5
    VI   = 6
    VII  = 7
    VIII = 8
    IX   = 9
    X    = 10
    '''
    if rn == 'I':
        return(1)
    elif rn == 'II':
        return(2)
    elif rn == 'III':
        return(3)
    elif rn == 'IV':
        return(4)
    elif rn == 'V':
        return(5)
    elif rn == 'VI':
        return(6)
    elif rn == 'VII':
        return(7)
    elif rn == 'VIII':
        return(8)
    elif rn == 'IX':
        return(9)
    elif rn == 'X':
        return(10)


# Q2)
def sum_even(n):
    '''
    Assume n is an integer >= 1.
    Return the sum of the integers, between 1-n inclusive, 
    that are even
    '''
    count=0
    for i in range(n+1):
        if i%2==0:
            count+=i
    return(count)


# Q3)
def integers_exceed(n):
    '''
    How many consecutive integers, starting at 1, must be
    added before the sum exceeds n?
    For example, if n is 11, we must add 1+2+3+4+5 = 15,
    and therefore the answer is 5.
    '''
    count=0
    inc=1
    while (n>count):
        inc+=1
        count+=inc
    return(inc)


# Q4)
def pyramid_blocks(n, m):
    '''
    Assume n and m are integers >= 1.
    Consider a solid rectangular pyramid, whose base is n-by-m 
    blocks. The layer above is (n-1)-by-(m-1), and so on. The top 
    layer will be n-by-1, or 1-by-m, depending on which dimension 
    reaches 1 first. Assume n and m are integers. Return the number 
    of blocks in the pyramid.
    '''
    blk=0
    for i in range(min(m,n)):
        blk+=(m-i)*(n-i)
    return(blk)

# Q5)
def first_letter(digits):
    '''
    Assume that digits is a string containing numeric digits.
    Returns a string whose corresponding characters are the first 
    letter of each digit.
    For example: '5113' returns 'foot',  since the first letters 
    of five, one, one, three are f, o, o, t.  
    Similarly, '0123456789613' returns 'zottffssensot'.
    '''
    newstr=""
    for i in digits:
        if i=="1":
            newstr=digits.replace(i,"o")
        elif i=="2" or i=="3":
            newstr=digits.replace(i,"t")
        elif i=="4" or i=="5":
            newstr=digits.replace(i,"f")
        elif i=="6" or i=="7":
            newstr=digits.replace(i,"s")
        elif i=="8":
            newstr=digits.replace(i,"e")
        elif i=="9":
            newstr=digits.replace(i,"n")
    return(newstr)

# Q6) 
def deduplicate(s):
    '''
    Assume that s is a string.
    Return a new string that is the same as s, but with consecutive 
    duplicate characters removed. For example, 'feeder' returns 'feder' 
    since it changes the 'ee' to 'e'.
    'boomboomeeraaang' returns 'bombomerang' .
    '''
    pass # replace 'pass' with a return statement.





        
