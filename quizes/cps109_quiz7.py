def rlen(x):
    if not x:
        return 0
    else:
        return 1 + rlen(x[1:])
    
a=[1,2,[3,4,[5],6]]
b=[9,9,9,9,9,9,9,9,9] #9 9 times
print(rlen(b)) #3