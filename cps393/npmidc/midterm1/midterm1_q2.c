#include <stdio.h>
#include <stdlib.h>


/*
    NAME: 
    CSID: 

    Q2: 4 marks)

    This question contains only a main() function. The main()
    function accepts any number of integer arguments from the
    command line.

    Dynamically allocate an array of ints to hold the arguments.
    Compute a running total as you go through the values in the
    order they were given. Write the results into a file named
    totals.txt, one line per value, followed by a final line with
    the overall total, using exactly this format:

        Step 1: 5
        Step 2: 3
        Step 3: 13
        Total: 13

    Here "Step k" shows the running total after the k-th value.

    If no arguments are provided, the file should contain only:

        No values

    Free all memory and close the file correctly.

    Example:  ./a.out 5 -2 10
              totals.txt then contains:
              Step 1: 5
              Step 2: 3
              Step 3: 13
              Total: 13
*/

int main(int argc, char *argv[])
{
    FILE *out;
    out = fopen("res.txt", "w");
    if (argc < 2) {
        fprintf(out, "no values");
        fclose(out);
    }

    int count = 0;
    for (int i = 0; i < argc-1; i++) {
        count += atoi(argv[i+1]);
        fprintf(out, "Step %d: %d\n", i+1, count);
    }
    fprintf(out, "Total: %d\n", count);
    fclose(out);
}
