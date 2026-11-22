#include <stdio.h>
#include <stdlib.h>
#include <string.h> 

/*
    NAME: 
    CSID: 

    Q3: 3 marks)

    This function accepts a string as input, and checks whether it
    is a palindrome (reads the same forwards and backwards). The 
    function returns 1 if the string is a palindrome, and 0 if it
    is not.

    The function also stores, at the address given by mismatch_out,
    the index of the FIRST character (counting from the left) that
    does not match its mirror character at the other end of the 
    string. If the string is a palindrome, store -1 at mismatch_out.
    The empty string counts as a palindrome. You may assume the 
    input string contains only lower-case letters.

    For example, "level"  returns 1 and stores -1 at mismatch_out.
                 "abcxba" returns 0 and stores 2 at mismatch_out
                          ('c' at index 2 does not match 'x').

    You may use functions from string.h, but they are not
    required to solve the problem.
*/

int palindrome (const char *str_in, int *mismatch_out)
{


    return -1; // change this, obviously.        
}

int main()
{
    int pos = 0, res;

    res = palindrome("racecar", &pos);    printf("%d %d\n", res, pos); // Should be 1 -1
    res = palindrome("abba", &pos);       printf("%d %d\n", res, pos); // Should be 1 -1
    res = palindrome("abcxba", &pos);     printf("%d %d\n", res, pos); // Should be 0 2
    res = palindrome("hello", &pos);      printf("%d %d\n", res, pos); // Should be 0 0
    res = palindrome("noonx", &pos);      printf("%d %d\n", res, pos); // Should be 0 0
    res = palindrome("abcdefdcba", &pos); printf("%d %d\n", res, pos); // Should be 0 4
    res = palindrome("q", &pos);          printf("%d %d\n", res, pos); // Should be 1 -1
    res = palindrome("", &pos);           printf("%d %d\n", res, pos); // Should be 1 -1

    return 0;
}