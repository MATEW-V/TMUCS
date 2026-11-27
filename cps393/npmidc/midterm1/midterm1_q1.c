#include <stdio.h>
#include <stdlib.h>

/*
    NAME: 
    CSID:

    Q1: 3 marks)

    This function accepts a non-negative integer n and returns the
    integer formed by reversing its digits. Leading zeros in the
    result disappear, so trailing zeros in n are dropped.

        reverse_digits(1230)  returns 321
        reverse_digits(90210) returns 1209
        reverse_digits(7)     returns 7
        reverse_digits(0)     returns 0

    No arrays are needed to solve this problem.
*/

int reverse_digits (int n)
{
    // Your code here
	int res = 0;
	while (n != 0) {
		int num = n % 10;
		res = res * 10 + num;
		n /= 10;
	}

    return res;
}

int main()
{
    printf("%d\n", reverse_digits(1230));    // should print: 321
    printf("%d\n", reverse_digits(90210));   // should print: 1209
    printf("%d\n", reverse_digits(7));       // should print: 7
    printf("%d\n", reverse_digits(0));       // should print: 0
    printf("%d\n", reverse_digits(100));     // should print: 1

    return 0;
}
