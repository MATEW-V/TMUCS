#include <stdio.h>

int main() { 
	int sum = 0;
	int count = 0;
	int num;
	float avg = 0.0;

	while (scanf("%d", &num) != EOF) {
		sum+=num;
		count++;
	} 
	avg = (float)sum/count;
	printf("Number of values: %d, Average number: %.2f\n", count, avg);
}