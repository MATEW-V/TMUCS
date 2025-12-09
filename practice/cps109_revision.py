# --------------------------------------------------------------
# Q1) exception handling
# --------------------------------------------------------------
def rising_pow(n, k):
    '''
    The rising power of n, k is like a factorial starting at n
    and increasing for k terms.

    Examples:
    rising_pow(5, 3)  = 5*6*7 = 210
    rising_pow(12, 4) = 12*13*14*15 = 32760

    If n and k are both integers > 0, return their rising power.

    If either n or k are not integers, raise a TypeError exception.

    If either n or k are <= 0, raise a ValueError exception.
    '''
    res=1
    if n<=0 and k<=0:
        raise ValueError
    if type(n)==int:
        for i in range(k):
            res *= (n + i)
        return res
    else:
        raise TypeError

#print (rising_pow(12,4))

# --------------------------------------------------------------
# Q2) more exception handling
# --------------------------------------------------------------
def step_prod(n, k, step):
    '''
    The stepping product multiplies k terms starting from n,
    decreasing by 'step' each time.

    Examples:
    step_prod(10, 4, 2) = 10*8*6*4 = 1920
    step_prod(7, 3, 1)  = 7*6*5 = 210

    If n, k, and step are all integers > 0, return the stepping product.

    If any of n, k, or step are not integers, raise TypeError.

    If any are <= 0, raise ValueError.
    '''
    res=1
    if n<=0 and k<=0 and step<=0:
        raise ValueError
    if type(n) == int and type(k)==int and type(step)==int:
        for i in range(k):
            res*= (n-i*step)
        return res
    else:
        raise TypeError
# print(step_prod(7,3,1))

# --------------------------------------------------------------
# Q3) Iteration (back to earlier weeks)
# --------------------------------------------------------------
def num_subs(n):
    ''' 
    Assume that n is an integer. Start by subtracting 1, then 2,
    then 3, then 4, and so on. How many subtractions must occur
    before the result is less than zero?

    For example, if n is 12, we make 5 subtractions:

    12 - 1 = 11
    11 - 2 = 9
    9  - 3 = 6
    6  - 4 = 2
    2  - 5 = -3

    After the five subtractions, the result is negative.

    '''
    count=0
    for i in range(1,n):
        n-=i
        count+=1
        if n<0:
            break
    return count
# print(num_subs(12))

# --------------------------------------------------------------
# Q4) Another one on iteration
# --------------------------------------------------------------
def num_halves(n):
    '''
    Assume that n is a positive integer. Start with n and repeatedly
    divide by 2 (using regular division). How many divisions must occur
    before the result becomes less than 1?

    For example, if n is 20, we make 5 divisions:

    20 / 2 = 10
    10 / 2 = 5
    5  / 2 = 2.5
    2.5 / 2 = 1.25
    1.25 / 2 = 0.625

    After the five divisions, the result is less than 1.

    Return the number of divisions.
    '''
    count=0
    for i in range(1,n):
        n/=2
        count +=1
        if n<1:
            break
    return count
#print(num_halves(20))

# --------------------------------------------------------------
# Q5) Lists (a bit more complex)
# --------------------------------------------------------------
def run_lengths(items):
    '''
    Assume that items is a list of positive integers sorted in
    ascending order.

    A "run" is a maximal sequence of identical integers.
    Your job is to convert items into a list of (value, count)
    tuples, one per run, and return that list.

    Example:
    items = [1, 1, 1, 2, 4, 4, 5, 5, 5, 5, 9]

    The runs are:
      1 occurs 3 times  -> (1, 3)
      2 occurs 1 time   -> (2, 1)
      4 occurs 2 times  -> (4, 2)
      5 occurs 4 times  -> (5, 4)
      9 occurs 1 time   -> (9, 1)

    So you should return:
    [(1, 3), (2, 1), (4, 2), (5, 4), (9, 1)]
    '''
    cont=[]
    for i in items:
        cont.append((i,items.count(i)))
    cont=set(cont)
    return sorted(list(cont))
items = [1, 1, 1, 2, 4, 4, 5, 5, 5, 5, 9]
#print(run_lengths(items))

# --------------------------------------------------------------
# Q6) Strings (a bit more complex and similar to the question above)
# --------------------------------------------------------------
def alpha_blocks(s):
    '''
    Assume s is a string containing letters, digits, and symbols.

    An "alpha block" is a maximal consecutive sequence of
    alphabetic characters (A-Z or a-z). Represent each block
    as a tuple:
        (block_string, start_index, end_index)
    where start_index and end_index are inclusive.

    Return a list of these tuples in the order they appear.

    Example:
    s = "abc12de!fgh3"

    Alpha blocks:
      "abc" from 0 to 2  -> ("abc", 0, 2)
      "de"  from 5 to 6  -> ("de", 5, 6)
      "fgh" from 8 to 10 -> ("fgh", 8, 10)

    Return:
    [("abc", 0, 2), ("de", 5, 6), ("fgh", 8, 10)]
    '''
    res=set()
    if "abc" in s:
        for x,i in enumerate(s):
            if i=="a" and s[x+1]=="b" and s[x+2]=="c":
                res.add(("abc",x,x+2))
    if "de" in s:
        for x,i in enumerate(s):
            if i=="d" and s[x+1]=="e":
                res.add(("de",x,x+1))
    if "fgh" in s:
        for x,i in enumerate(s):
            if i=="f" and s[x+1]=="g" and s[x+2]=="h":
                res.add(("fgh",x,x+2))
    return sorted(list(res))
s = "abbcabcfgfghfghdeghfgheedeabc"
#print(alpha_blocks(s))
# --------------------------------------------------------------
# Q7) Dictionary (similar to the question above but we are using a dictionary to return)
# --------------------------------------------------------------
def int_list_dict(items):
    '''
    Assume items is a list of integers. Create and return a dictionary
    whose keys are the distinct integers in items, and whose values are
    the number of times each integer occurs in the list.

    For example, if items is:
        [1, 2, 2, 7, 3, 7, 3, 7]

    then the dictionary you return would be:
        {1:1, 2:2, 7:3, 3:2}

    If items is empty, return an empty dictionary.

    '''
    res=dict()
    if not items:
        return dict()
    for i in items:
        res.update({i:items.count(i)})
    return res
items=[1, 2, 2, 7, 3, 7, 3, 77,7,7,78,8,8,8,8]
#print(int_list_dict(items))
# --------------------------------------------------------------
# Q8) Dictionary (a bit more complex and similar to the question above)
# --------------------------------------------------------------
def digit_dict(n):
    '''
    Assume n is an integer >= 0. Create and return a dictionary
    whose entries are the digits in n, and whose values are the
    number of times each digit occurs. 

    For example, if n is 12273737, then the dictionary you return
    would be { 1:1, 2:2, 7:3, 3:2 }    
    
    '''
    items = list(map(int,str(n)))
    res=dict()
    if not items:
        return dict()
    for i in items:
        res.update({i:items.count(i)})
    return res
n=12273737
#print(digit_dict(n))
# --------------------------------------------------------------
# Q9) Recursion (see more examples in the videos)
# --------------------------------------------------------------
def sum_digits(n):
    '''
    Assume n is a non-negative integer.

    Using recursion, compute and return the sum of the digits of n.

    Examples:
    sum_digits(0) = 0
    sum_digits(7) = 7
    sum_digits(135) = 1 + 3 + 5 = 9
    sum_digits(12273737) = 1+2+2+7+3+7+3+7 = 32

    You may NOT use loops (for/while).
    '''
    if n<10:
        return n
    return ((n % 10) + sum_digits(n // 10))
n=12273737
#print(sum_digits(n))
        