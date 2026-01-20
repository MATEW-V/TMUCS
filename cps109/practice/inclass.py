car = {"brand": "x", "model":"y", "year":"z"}

car.update({"color":"blue"})

car["year"]="2025"

del car["model"]


animals=["cat","dog","cat","bird","dog","cat","fish"]

def animcount(list):
    count=0
    animdict={"cat":0,"dog":0,"bird":0,"fish":0}
    for i in list:
        if i == animdict[i]:
            animdict.update({i:count})
            count+=1
    return(animdict) #ts sucks fix it

def countdown(n):
    if n<1:
        return
    else:
        print(n)
        countdown(n-2)

def factorial(n):
    if n==0:
        return(1)
    else:
        return(n*factorial(n-1))

def fib(n):
    if n==1:
        return(1)
    elif n==0:
        return(0)
    else:
        return(fib(n-1)+fib(n-2))
a=108
b=2
m=4
for i in range(10000):
    m=m-((m**8)/(a+m**8)*m)+b
print(m)