#include <stdio.h>
#include <stdlib.h>

void swap (int *x, int *y) {
    int temp = *y;
    *y = *x;
    *x = temp;
}

void min_max (int *arr, int len, int *min, int *max) {
    int localmin = *arr;
    int localmax = *arr;

    for (int i = 1; i < len; i++) {
        arr++;
        if (*arr < localmin) {
            localmin = *arr;
        } else if (*arr > localmax) {
            localmax = *arr;
        }
    }

    *min = localmin;
    *max = localmax;
}
//for qsort
int compare_ints(const void *a, const void *b) {
    int arg1 = *(const int *)a;
    int arg2 = *(const int *)b;
    if (arg1 < arg2) return -1;
    if (arg1 > arg2) return 1;
    return 0;
}

void mmm (int *arr, int len, float *mean, int *median, int *mode) {
    if (arr == NULL || len <= 0) return;
    
    qsort(arr, len, sizeof(*arr), compare_ints);

    int sum = *arr;
    int *start = arr;
    int *median1 = arr + (len/2);
    int *median2 = arr + (len/2) - 1;

    for (int i = 1; i < len; i++) {
        arr++;
        sum+=*arr;
    }

    *mean = (float) sum/len;

    if (len%2 == 1) {
        *median = *median1;
    } else {
        *median = (*median1 + *median2)/2;
    }

    int max_count = 1, count = 1;
    *mode = *start;
    for (int i = 1; i < len; i++) {
        if (*(start + i) == *(start + i - 1)) {
            count++;
        } else {
            count = 1;
        }
        if (count > max_count) {
            max_count = count;
            *mode = *(start + i);
        }
    }
 }
