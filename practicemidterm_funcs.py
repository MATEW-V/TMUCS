'''
This practice test contains 5 programming questions. 

For the practice test and your midterm, some unit tests are transparent, and some are not. This means that the number of unit tests passed is not a guarantee of your 
mark, but it's a good indication of how well you've done.

Remember:
- Save often. We can't recover unsaved work.
- Be very careful to AVOID infinite loops and infinite sequence 
  creation! Your computer can freeze for upwards of 10 minutes. 
  You will lose this time.
- Test your code in Spyder first (or other IDE). Run the file, load the functions, test them in the interactive shell, etc. Your time is limited, and 
  testing locally will be a much faster workflow.
-  Every programming question is weighted equally.
- You will have about 90 minutes to complete these questions (maybe not in today's class but that's how you need to practice)


Try and be as "real" as possible and use this as a learning experience
'''
# --------------------------------------------------------------
# Q1) 
# --------------------------------------------------------------
def rock_paper_scissors(hand):
    '''
    Assume hand is a string. This function returns the counter 
    play in a game of rock, paper, scissors.
    If hand is 'rock', return 'paper'
    If hand is 'paper', return 'scissors'
    If hand is 'scissors', return 'rock'
    If hand is none of these, return None.
    '''
    if hand == 'paper':
        return("scissors")
    elif hand == 'rock':
        return("paper")
    elif hand == 'scissors':
        return("rock")
    else:
        return(None)

# --------------------------------------------------------------
# Q2) 
# --------------------------------------------------------------
def digit_sum(num1, num2):
    '''
    Assume num1 and num2 are integers with the same number of digits.
    Return the sum of the products of each number's corresponding 
    digits. Eg: 123 and 321 would be (1*3)+(2*2)+(3*1) = 10
    '''
    list1 = list(map(int,str(num1)))
    list2 = list(map(int,str(num2)))
    sum=0
    for i in range(len(list1)):
        sum+=list1[i]*list2[i]
    return(sum)
# --------------------------------------------------------------
# Q3) 
# --------------------------------------------------------------
def staircase_blocks(i, j):
    '''
    Assume i and j are integers >= 1. Consider a staircase structure
    where the bottom step is n blocks wide and m blocks tall. Each
    step above is 1 block narrower (width decreases by 1) and also
    1 block shorter (height decreases by 1). The staircase continues
    until either the width or height reaches 0. Return the total 
    number of blocks in the staircase.
    
    Example: staircase_blocks(4, 3)
    Step 1: 4 wide × 3 tall = 12 blocks
    Step 2: 3 wide × 2 tall = 6 blocks
    Step 3: 2 wide × 1 tall = 2 blocks
    (stops here because height reached 0)
    Total: 12 + 6 + 2 = 20 blocks
    '''
    sum=0
    for x in range(min(i,j)+1):
        sum+=i*j
        i-=1
        j-=1
    return(sum)

# --------------------------------------------------------------
# Q4) 
# --------------------------------------------------------------
def count_divisible_pairs(items):
    '''
    Assume items is a list of integers. Count how many pairs of 
    elements exist where the first element is evenly divisible by 
    the second element (with no remainder). A pair consists of two 
    elements at different positions where the element at the smaller 
    index is divisible by the element at the larger index. Note that 
    division by zero is undefined, so skip any zeros in the list.
    Return the count of such pairs.
    
    Example: count_divisible_pairs([12, 3, 8, 4, 6])
    - 12 divisible by 3? Yes (12/3 = 4) ✓
    - 12 divisible by 4? Yes (12/4 = 3) ✓
    - 12 divisible by 6? Yes (12/6 = 2) ✓
    - 8 divisible by 4? Yes (8/4 = 2) ✓
    Returns: 4
    '''
    count=0
    for i in range(len(items)):
        for j in range(i+1,len(items)):#i+1 , len(items) to avoid double counting
            if items[j] != 0 and items[i] % items[j] == 0:
                count+=1
    return(count)
# --------------------------------------------------------------
# Q5) 
# --------------------------------------------------------------
def remduplicate(word):
    '''
    Assume that word is a string. Return a string that is the same 
    as word, but with consecutive duplicate characters removed. 
    For example, 'moody' returns 'mody' since it changes the 
    'oo' to 'o'. 'zoomzoomeeraaanng' returns 'zomzomerang'.
    '''
    wlist = list(word)
    newlist = []
    for i in range(len(wlist)):
        if i == 0:
            newlist.append(wlist[i])
        elif wlist[i] != wlist[i-1]:
            newlist.append(wlist[i])
    return("".join(newlist))