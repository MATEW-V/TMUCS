#include <stdio.h>
#include <stdlib.h>


/*
    NAME: Matthew Vuong
    CSID: mevuong

    Q2: 4 marks)

    This question contains only a main() function. It accepts two
    command line arguments:

        argv[1]  N, the number of students in the file scores.txt
        argv[2]  T, a passing threshold

    The file scores.txt contains exactly N lines. Each line holds
    a student's name (no spaces, at most 15 characters) followed by
    an integer score, for example:

        alice 88
        bob 61

    Dynamically allocate an array of N students. Each student has
    a name and a score. Read all N students from scores.txt into
    the array, in file order.

    Then write a file named report.txt. Include one line for each
    student whose score is greater than or equal to T, in file
    order, using the format "name score". Finish the file with:

        Passed: k of N

    where k is the number of students written.

    If N is 0, the file should contain only:

        No students

    Free all memory and close all files correctly.

    Example: scores.txt contains the four lines alice 88, bob 61,
             carol 75, dan 92.
             ./a.out 4 70 produces report.txt containing:
                 alice 88
                 carol 75
                 dan 92
                 Passed: 3 of 4
*/

typedef struct {
    char name[16];
    int score;
} Student;

int main(int argc, char *argv[])
{
	FILE *out;
    out = fopen("report.txt", "w");
    FILE *in;
    in = fopen("scores.txt", "r");
    
    if (in == NULL) {
        perror("scores.txt");
        fclose(out);
        return 1;
    }

    int lines = atoi(argv[1]);
    int thresh = atoi(argv[2]);

    if (lines == 0) {
        fprintf(out, "No students\n");
        fclose(out);
        return 0;
    }
    Student *students = malloc(lines * sizeof(Student));
    if (students == NULL) {
        fclose(in);
        fclose(out);
        return 1;
    }

    for (int i = 0; i < lines; i++) {
        if (fscanf(in, "%15s %d", students[i].name, &students[i].score) != 2) {
            break;
        }
    }
    
    int pass = 0;
    for (int i = 0; i < lines; i++) {
        if (students[i].score >= thresh) {
            fprintf(out, "%s %d\n", students[i].name, students[i].score);
            pass++;
        }
    }
    fprintf(out, "Passed: %d of %d\n", pass, lines);
    fclose(out);
}
