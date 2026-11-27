#include <stdio.h>
#include <stdlib.h>


/*
    NAME:
    CSID:

    Q2: 4 marks)

    This question contains only a main() function. It accepts two
    command line arguments, R (rows) and C (columns), both positive
    integers.

    Dynamically allocate an R by C matrix of ints. Use either the
    "array of row pointers" method or the "one flat block" method
    from class. Fill the matrix so that the element in row r and
    column c (both counting from 0) equals (r + 1) * (c + 1).

    Write the matrix into a file named matrix.txt. Each row is one
    line, with the values separated by single spaces. After the
    matrix, write one more line:

        Diagonal sum: S

    where S is the sum of the main diagonal elements, that is,
    m[i][i] for every i from 0 up to (but not including) the
    smaller of R and C.

    If R or C is less than 1, the file should contain only:

        invalid

    Free all memory and close the file correctly.

    Example: ./a.out 3 4 produces matrix.txt containing:
        1 2 3 4
        2 4 6 8
        3 6 9 12
        Diagonal sum: 14
*/

int main(int argc, char *argv[])
{
    // Your code here



    return 0;
}
