#include <stdio.h>
#include <stdlib.h>

/*
    NAME: Matthew Vuong
    CSID: mevuong

    Q1: 3 marks)

    The Collatz rule for a positive integer n is:
        if n is even, the next value is n / 2
        if n is odd,  the next value is 3 * n + 1

    Starting from n, apply the rule repeatedly until the value
    becomes 1. This function returns the number of steps taken.

    If n is less than 1, the function returns -1.

    Examples:
        collatz_steps(1)  returns 0
        collatz_steps(2)  returns 1    (2 -> 1)
        collatz_steps(6)  returns 8    (6 3 10 5 16 8 4 2 1)
        collatz_steps(7)  returns 16
        collatz_steps(0)  returns -1

    No arrays are needed to solve this problem.
*/

int collatz_steps (int n)
{
   if (n<1) {
    return -1;
   }
   int count = 0;
   while (n!=1) {
    count++;
    if (n%2 == 0) {
        n = n/2;
    } else {
        n = 3 * n + 1;
    }
   }
   return count;
}

int main()
{
    printf("%d\n", collatz_steps(1));    // should print: 0
    printf("%d\n", collatz_steps(2));    // should print: 1
    printf("%d\n", collatz_steps(6));    // should print: 8
    printf("%d\n", collatz_steps(7));    // should print: 16
    printf("%d\n", collatz_steps(27));   // should print: 111
    printf("%d\n", collatz_steps(0));    // should print: -1

    return 0;
}
