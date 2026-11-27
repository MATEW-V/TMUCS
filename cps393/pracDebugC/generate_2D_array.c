#include <stdio.h>
#include <stdlib.h>

// Create a function that takes two integers as input - the number 
// of rows and number of columns. The function should return a 2D 
// array (double integer pointer) where each element is increasing 
// in value starting at 0, and each row continues where the previous 
// row ended. For example, {{0,1,2}, {3,4,5}, {6,7,8}}

int **make_2D_Array(int rows, int cols){
    int **arr2d;
    arr2d = calloc(rows, sizeof(int *));
    int val = 0;

    for (int i = 0; i < rows; i++) {
        arr2d[i] = calloc(cols, sizeof(int));

        for (int k = 0; k < cols; k++) {
            arr2d[i][k] = val;
            val++;
        }
    }
    return arr2d;
}


// Create a function that receives a 2D array (double int pointer) and the
// dimensions of the array as input. Print the contents of the array in a 
// nice format, evently spacing the elements with each row on a separate line.
// Use commas to separate elements, and commas to separate the rows.

void print_2D_Array(int** grid, int rows, int cols){
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d, ", grid[i][j]);
        }
        printf("\n");
    }
}



int main(void){

	int rows1 = 3;
	int cols1 = 3;
	int **ans1 = make_2D_Array(rows1,cols1);
	print_2D_Array(ans1,rows1,cols1);
	printf("=======\n");

	int rows2 = 4;
        int cols2 = 5;
        int **ans2 = make_2D_Array(rows2,cols2);
        print_2D_Array(ans2,rows2,cols2);
	printf("=======\n");

	int rows3 = 8;
        int cols3 = 1;
        int **ans3 = make_2D_Array(rows3,cols3);
        print_2D_Array(ans3,rows3,cols3);

}
