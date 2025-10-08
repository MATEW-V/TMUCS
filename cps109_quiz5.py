list=[1,2,3,4,5,6,7,8]
list2=["bob","jack"]
def faro(deck,bool):
    if bool==True:
        p1=deck[:len(deck)//2] #[:] splits the list in half and whichever sie : is on it takes that half
        p2=deck[len(deck)//2:]
    else:
        p2=deck[:len(deck)//2]
        p1=deck[len(deck)//2:]
    shuffled=[]
    for i in range(len(p1)):
        shuffled.append(p1[i])
        shuffled.append(p2[i])
    return(shuffled)

print(faro(list,True))