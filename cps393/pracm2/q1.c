#include <stdio.h>
#include <stdlib.h>

/*
    NAME: Matthew Vuong
    CSID: mevuong

    Q1: 3 marks)

    This function accepts two integers, lo and hi, and prints every
    PRIME number between lo and hi (inclusive) on a single line, to
    stdout. A prime number is an integer greater than 1 whose only
    divisors are 1 and itself (2, 3, 5, 7, 11, ...).

    Print each prime followed by a single space. Then, on the same
    line, print how many primes were found, in this format:

        11 13 17 19 (4 primes)

    If there are no primes in the range, only the count is printed:

        (0 primes)

    If lo is greater than hi, print "invalid" instead.
    Every call must end its output with a newline.

    No arrays are needed to solve this problem.
*/

void print_primes (int lo, int hi)
{
    int count = 0;
    if (lo > hi) {
        printf("%s\n","invalid");
        return;
    }

    for (int k = lo; k <= hi; k++) {
        if (k < 2) continue;
        int is_prime = 1;

        for (int i = 2; i*i <= k; i++) {
            if (k % i == 0) {
                is_prime = 0;
                break;
            }
        }

        if (is_prime) {
            printf("%d ", k);
            count++;
        }
    }
    printf("(%d primes)\n", count);
}

int main()
{
    print_primes(10, 20);   // should print: 11 13 17 19 (4 primes)
    print_primes(1, 10);    // should print: 2 3 5 7 (4 primes)
    print_primes(-5, 3);    // should print: 2 3 (2 primes)
    print_primes(24, 28);   // should print: (0 primes)
    print_primes(97, 97);   // should print: 97 (1 primes)
    print_primes(90, 110);  // should print: 97 101 103 107 109 (5 primes)
    print_primes(8, 2);     // should print: invalid

    return 0;
}
