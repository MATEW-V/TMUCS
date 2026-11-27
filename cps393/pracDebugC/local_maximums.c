#include <stdio.h>
#include <stdlib.h>

/*   Guide for neighbour coordinates

     [i-1][j-1]  [i-1][j]  [i-1][j+1]
               ↖    ↑    ↗

     [i][j-1]  ← [i] [j] →   [i][j+1] 

               ↙    ↓    ↘
     [i+1][j-1]  [i+1][j]  [i+1][j+1]
 
 */


int** local_maximums(int values[][5], int numRows){

	// Create the result double pointer, whose elements
	// are pointers to the values in the grid. We need to allocate
	// space for numRows * the size of an int pointer (address)



	// After allocating space for result (i.e. the number of
	// rows), we need to allocate the space for each of the rows (i.e.
	// allocate space for the elements or the columns).




	// Note - C doesn't let you create 2D arrays with variable lengths.
	// This means we can't have the definition look like this:
	// int result[numRows][5] = ...
	
	// So instead, we define result as int** result, which means
	// we have a pointer that we can use to access other pointers.
	// This SOUNDS like an array of arrays, but the way the data is
	// stored would be different. A true 2D array could be contiguous
	// memory. Here, we have a pointer to an allocated space of memory,
	// and its elements are also pointers (addresses of allocated memory),
	// NOT INTEGERS. 
	
	// Conveniently, we can use the same addressing notation to retreive
	// our values all the same, but we can't simply transfer between the
	// two data types. int** array != array[#][#].	
	// End Note



}


void print2DArr(int grid[][5], int numRows){
	// This function takes a 2D array as input and prints
	// the values out. This function cannot take int** as
	// input

	// Printing results
        for (int rownum = 0; rownum < numRows; rownum++){
                printf("{");

                for (int colnum = 0; colnum < 5; colnum++){
			printf("%2d", grid[rownum][colnum]);
			if (colnum != 4){
				printf(", ");
			}
		}

		printf("}\n");
	}	
	printf("\n");
}


void print2DPointer(int** grid, int numRows){
	// This function takes a double pointer as input and
	// prints the values out. This function cannot take a
	// 2D array as input
	
        // Printing results
        for (int rownum = 0; rownum < numRows; rownum++){
                printf("{");

                for (int colnum = 0; colnum < 5; colnum++){
                        printf("%2d", grid[rownum][colnum]);
                        if (colnum != 4){
                                printf(", ");
                        }
                }

                printf("}\n");
        }
        printf("\n");
}


int main(){
	
	// Input1 is a 2D array
	int input1[4][5] = { {17, 12, 86, 87, 88},
		    	 {18, 15, 5, 12, 9},
		    	 {4, 13, 27, 11, 50},
		    	 {7, 8, 9, 10, 7}};

	// Expected answer for Input1
	int answer1[4][5] = {0,0,0,0,88,18,0,0,0,0,0,0,27,0,50,0,0,0,0,0};

	// Result1 is a 2D pointer - NOT THE SAME AS 2D ARRAY
	int** result1 = local_maximums(input1, 4);


	int input2[6][5] = {{46 ,19 ,42 ,38 ,7},
			    {30 ,32 ,34 ,31 ,37},
			    {2 ,43 ,45 ,30 ,8},
			    {11 ,37 ,2 ,10 ,19},
			    {6 ,29 ,34 ,31 ,20},
			    {22 ,32 ,35 ,20 ,17}};

	int answer2[6][5] = {{46,  0, 42,  0,  0},
			     { 0,  0,  0,  0,  0},
			     { 0,  0, 45,  0,  0},
			     { 0,  0,  0,  0,  0},
			     { 0,  0,  0,  0,  0},
			     { 0,  0, 35,  0,  0}};

	int** result2 = local_maximums(input2, 6);


	int input3[7][5] = 
		{{30, 11, 20, 8, 47},
		 {10, 41, 16, 30, 13},
		 {17, 38, 2, 44, 16},
		 {17, 2, 32, 0, 23},
		 {2, 47, 30, 13, 42},
		 {44, 36, 22, 45, 34},
	    	 {28, 7, 3, 27, 30}};

	int answer3[7][5] = 
		{{ 0,  0,  0,  0, 47},
		 { 0, 41,  0,  0,  0},
		 { 0,  0,  0, 44,  0},
		 { 0,  0,  0,  0,  0},
		 { 0, 47,  0,  0,  0},
		 { 0,  0,  0, 45,  0},
		 { 0,  0,  0,  0,  0}};
	
	int** result3 = local_maximums(input3, 7);


	// Test 1
	printf("Original:\n");
	print2DArr(input1, 4);

	printf("Expected:\n");
	print2DArr(answer1, 4);

	printf("Actual:\n");
	print2DPointer(result1, 4);

	printf("==================\n\n");

	// Test 2
	printf("Original:\n");
        print2DArr(input2, 6);

        printf("Expected:\n");
        print2DArr(answer2, 6);

        printf("Actual:\n");
        print2DPointer(result2, 6);

	printf("==================\n\n");


	// Test 3
        printf("Original:\n");
        print2DArr(input3, 7);

        printf("Expected:\n");
        print2DArr(answer3, 7);

        printf("Actual:\n");
        print2DPointer(result3, 7);

	return 1;
}