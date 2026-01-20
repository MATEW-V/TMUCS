print("Enter an integer from 1-100: ")
n=int(input())
if n < 1:
    print("N must be greater than 1")
elif n>100:
    print("too much work, no thanks")
else:
    for i in range(1,n+1):
        if i%3 == 0 and i%5 != 0:
            print("Fizz")
        elif i%5 == 0 and i%3 != 0:
            print("Buzz")
        elif i%3 == 0 and i%5 == 0:
            print("FizzBuzz")
        else:
            print(i)