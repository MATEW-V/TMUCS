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
    return(x)

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
    return(checka)

def is_cyclops(n):
    x=str(n)
    if x=="0":
        return(True)
    if "0" in x and x.count("0")==1 and x[len(x)//2]=="0" and x[-1]!="0" and len(x)%2!=0:
        return(True)
    else:
        return(False)
    
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
    return x[0] #redo this too bum

def count_dominators(items):
    if len(items)==0:
        return 0
    count=1
    cmax=items[-1]
    for i in reversed(range(0, len(items)-1)):
        if items[i]>cmax:
            count+=1
            cmax=items[i]
    return count