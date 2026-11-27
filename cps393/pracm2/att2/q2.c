#include <stdio.h>
#include <stdlib.h>


/*
    NAME: Matthew Vuong 
    CSID: mevuong

    Q2: 4 marks)

    This question contains only a main() function. The main()
    function accepts any number of arguments from the command line.

    Assume each argument is a floating point lap time in seconds
    (e.g. 63.45) from a single race. Dynamically allocate an array 
    of doubles to hold these lap times.

    Find the FASTEST (smallest) lap time. Then, for every lap in the
    order it was given, print how many seconds slower it was than 
    the fastest lap. Print the results into a file named laps.txt, 
    one line per lap (laps are numbered starting at 1), followed by
    a final line showing the fastest time, using exactly this format
    (two decimal places):

        Lap 1: +1.25
        Lap 2: +0.00
        Lap 3: +3.10
        Fastest: 60.40

    If no lap times are provided, the file should contain only:

        No laps

    Free all memory and close the file correctly.

    Example:  ./a.out 62.5 60.0 61.25
              laps.txt then contains:
              Lap 1: +2.50
              Lap 2: +0.00
              Lap 3: +1.25
              Fastest: 60.00
*/

int main(int argc, char *argv[])
{
    FILE *out;
    out = fopen("laps.txt", "w");

    if (argc < 2) {
        fprintf(out, "No laps");
        fclose(out);
        return 0;
    }

    double *data = malloc(argc-1 * sizeof(double));
    double min = atof(argv[1]);

    for (int i = 0; i < argc-1; i++) {
        data[i] = atof(argv[i+1]);
    }

    for (int i = 0; i < argc-1; i++) {
        if (min > data[i]) min = data[i];
        fprintf(out, "Lap %d: +%.2f\n",i+1, data[i]-min);
    }

    fprintf(out, "Fastest: %.2f", min);
    free(data);
    fclose(out);
    return 0;
}