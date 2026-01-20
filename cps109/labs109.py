def ryerson_letter_grade(n):
    if n < 50:
        return 'F'
    elif n > 89:
        return 'A+'
    elif n > 84:
        return 'A'
    elif n > 79:
        return 'A-'
    tens = n // 10
    ones = n % 10
    if ones < 3:
        adjust = "-"
    elif ones > 6:
        adjust = "+"
    else:
        adjust = ""
    return "DCB"[tens - 5] + adjust

def is_ascending(items):
    x=True
    for i in range(1,len(items)):
        if items[i]<=items[i-1]:
            return(False)
        else:
            pass
    return(x)#W

def riffle(items, out=True):
    if out==True:
        h1=items[:len(items)//2]
        h2=items[len(items)//2:]
    else:
        h2=items[:len(items)//2]
        h1=items[len(items)//2:]
    shuffle=[]
    for i in range(len(h1)):
        shuffle.append(h1[i])
        shuffle.append(h2[i])
    return(shuffle) #optimize

def only_odd_digits(n):
    checka=True
    for i in str(n):
        if int(i)%2==0:
            checka=False
    return(checka)#W

def is_cyclops(n):
    x=str(n)
    if x=="0":
        return(True)
    if "0" in x and x.count("0")==1 and x[len(x)//2]=="0" and x[-1]!="0" and len(x)%2!=0:
        return(True)
    else:
        return(False)#W
    
def domino_cycle(tiles):
    if not tiles:
        return(True)
    if len(tiles) == 1:
        return tiles[0][0] == tiles[0][1]

    return all(tiles[i][1] == tiles[i + 1][0] for i in range(len(tiles) - 1)) and tiles[0][0] == tiles[-1][1]
#redo this stupid

def colour_trio(colors):
    cset = {"y", "r", "b"}
    x = list(colors)
    while len(x) > 1:
        new_x = []
        for i in range(1,len(x)):
            if x[i] == x[i-1]:
                new_x.append(x[i])
            else:
                new_x.append((cset - {x[i], x[i-1]}).pop()) #note
        x = new_x
    return x[0] #redo this too bum #W

def count_dominators(items):
    if len(items)==0:
        return 0
    count=1
    cmax=items[-1]
    for i in reversed(range(0, len(items)-1)):
        if items[i]>cmax:
            count+=1
            cmax=items[i]
    return count #W

def extract_increasing(digits):
    res=[]
    prev=-1
    curr=0
    for i in digits:
        curr=10*curr+int(i)
        if curr>prev:
            res.append(curr)
            prev=curr
            curr=0 #ONLY RESET IF TRUE
    return(res)
    #bc curr starts at 0, its just i. it gets appended, prev = curr, then curr is reset. then if not greater it skips AND curr stays. 

# def words_with_letters(words, letters): #COME BACK HERE LATER, 2-POINTER SORT ALGORITHM ALSO GRAB words_sorted.txt frim the git
#     result = []
#     if not letters:
#         return words
#     for i in words:  # Using i instead of word
#         # Check if letters is a subsequence of i
#         letter_ptr = 0  # pointer for letters
#         word_ptr = 0    # pointer for current word i
        
#         while letter_ptr < len(letters) and word_ptr < len(i):
#             if letters[letter_ptr] == i[word_ptr]:
#                 letter_ptr += 1
#             word_ptr += 1
#         if letter_ptr == len(letters):
#             result.append(i)
#     return result
    
def taxi_zum_zum(moves):
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    x, y = 0, 0  # Start at origin
    direction_index = 0  
    for move in moves:
        if move == 'L':
            # Turn left (counterclockwise)
            direction_index = (direction_index - 1) % 4 #0,1,2,3
        elif move == 'R':
            # Turn right (clockwise)
            direction_index = (direction_index + 1) % 4
        elif move == 'F':
            # Move forward in current direction
            dx, dy = directions[direction_index]
            x += dx
            y += dy
    return(x,y)

def give_change(amount,coins):
    change=[]
    for i in coins:
        if amount==0 or sum(change)==amount:
            break
        for j in range(amount//i):
            change.append(i)
            amount=amount-i
    return(change) #W

def safe_squares_rooks(n,rooks):
    data=list(sum(rooks,()))
    xr = len({x for i, x in enumerate(data) if i % 2 == 0})
    yr = len({y for i, y in enumerate(data) if i%2!=0})
    if xr>=yr:
        return((n**2)-xr*n-yr*(n-xr))
    else:
        return((n**2)-yr*n-xr*(n-yr)) #W

# def words_with_given_shape(words, shape):  //uses words_sorted.txt do later
#     pass

def is_left_handed(pips):
    pass
