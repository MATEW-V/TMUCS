print("Enter a number: ")
num = int(input())
fact=""
if num%2==0:
    fact = "2, "
if num%3==0:
    fact = fact+"3, "
if num%4==0:
    fact = fact+"4, "
if num%5==0:
    fact = fact+"5, "
if num%6==0:
    fact = fact+"6, "
if num%7==0:
    fact = fact+"7, "
if num%8==0:
    fact = fact+"8, "
if num%9==0:
    fact = fact+"9, "
if num%10==0:
    fact = fact+"10, "
correctedfact = fact[:-2]

if fact=="":
    print("This number has no factors between 2 and 10")
else:
    print("The factors of "+str(num)+" between 2 and 10 are: "+str(correctedfact))