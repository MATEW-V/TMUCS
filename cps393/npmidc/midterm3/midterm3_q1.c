#include <stdio.h>
#include <stdlib.h>

/*
    NAME:
    CSID:

    Q1: 3 marks)

    This function accepts a non-negative integer n and a digit d
    (0 to 9). It returns the number of times the digit d appears
    in the decimal representation of n.

    Examples:
        count_occurrences(1220, 2)  returns 2
        count_occurrences(1000, 0)  returns 3
        count_occurrences(5, 1)     returns 0
        count_occurrences(0, 0)     returns 1

    No arrays are needed to solve this problem.
*/

int count_occurrences (int n, int d)
{
    // Your code here


    return 0;   // change this
}

int main()
{
    printf("%d\n", count_occurrences(1220, 2));   // should print: 2
    printf("%d\n", count_occurrences(1000, 0));   // should print: 3
    printf("%d\n", count_occurrences(5, 1));      // should print: 0
    printf("%d\n", count_occurrences(0, 0));      // should print: 1
    printf("%d\n", count_occurrences(9999, 9));   // should print: 4

    return 0;
}
