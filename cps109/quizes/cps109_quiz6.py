def is_prime(n):
    for i in range(2,n-1):
        if n%i==0:
            return(False)
        else:
            return(True)

def challengeprime(n):
    for i in range(2,10):
        if n <= 2:
            return(True)
        elif n%i==0:
            return(False)
        else:
            return(True)
        
print(challengeprime(67))
