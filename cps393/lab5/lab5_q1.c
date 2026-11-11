#include <stdio.h>

int main() {
    int n;

    printf("Enter an integer: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Invalid input. Please enter a positive integer.\n");
        return 1;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) {
                printf("%d ", i);
            } else {
                printf("* ");
            }
        }
        printf("\n");
    }
    printf("\n");

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) {
                printf("%d ", n - i + 1);
            } else {
                printf("* ");
            }
        }
        printf("\n");
    }
    printf("\n");

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (j == n - i + 1) {
                printf("%d ", i);
            } else {
                printf("* ");
            }
        }
        printf("\n");
    }
    printf("\n");

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (j == n - i + 1) {
                printf("%d ", n - i + 1);
            } else {
                printf("* ");
            }
        }
        printf("\n");
    }

    return 0;
}