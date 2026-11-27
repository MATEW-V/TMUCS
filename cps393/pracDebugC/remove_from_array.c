#include <stdio.h>
#include <stdlib.h>


void print_array(int *arr, int len){
	printf("{ ");

	for (int i=0; i<len; i++){
		printf("%d ", arr[i]);
	}
	printf("}\n");

}


// Define the remove_from_array function here!







int main(void){

	int len, x, y;

	int arr1[10] = {1,2,3,4,2,3,4,3,4,4};
	len = 10;
	x = 4;
	int *res1 = remove_from_array(arr1, len, x, &y);

	print_array(res1, y);

	int arr2[13] = {6,5,4,7,6,5,5,3,2,3,1,10,55};
	len = 13;
	x = 5;
	int *res2 = remove_from_array(arr2, len, x, &y);

	print_array(res2, y);

	int arr3[8] = {8,7,6,5,4,3,2,1};
	len = 8;
	x = 0;
	int *res3 = remove_from_array(arr3, len, x, &y);

	print_array(res3,y);

}