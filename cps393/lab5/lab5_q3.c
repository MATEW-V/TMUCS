#include <stdio.h>

int main() {
	int n;

	printf("Enter an Integer: ");
	if (scanf("%d", &n) != 1 || n <= 0) {
        	printf("Invalid input. Please enter a positive integer.\n");
        	return 1; 
    	}
	if (n == 1) {
                printf("1 has no prime factors.\n");
                return 0;
        }
	while (n % 2 == 0) {
		printf("%d*", 2);
		n /= 2;
	}
	for (int i = 3; i * i <= n; i += 2) {
		while (n % i == 0) {
			printf("%d*", i);
			n /= i;
		}
	}
	if (n > 2) {
		printf("%d*", n);
	}
	printf("\b \b\n");
	return 0;
}