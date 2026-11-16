#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>

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

char* my_str_cat (char *s1, char *s2) {
    int s1len = 0;
    int s2len = 0;

    while (s1[s1len] != '\0') {
        s1len++;
    }
    while (s2[s2len] != '\0') {
        s2len++;
    }

    char *res = calloc((s1len+s2len+1), sizeof(char));

    for (int i = 0; i < s1len; i++) {
        res[i] = *s1;
        s1++;
    }
    for (int i = 0; i < s2len; i++) {
        res[i+s1len] = *s2;
        s2++;
    }

    return res;
    //free it yoself
}

int* find_first (int *arr, int len, int value) {
    if (arr == NULL) {
        return NULL;
    }
    for (int i = 0; i < len; i++) {
        if (arr[i] == value) {
            return &arr[i];
        }
    }
    return NULL;
}

int* vec_add (int *v1, int len1, int *v2, int len2) {
    if (!v1 || !v2 || len1 < 0 || len2 < 0) return NULL;

    int max_len = (len1 > len2) ? len1 : len2;
    int min_len = (len1 < len2) ? len1 : len2;
    int *largest = (len1 >= len2) ? v1 : v2;
    int *small = (len1 >= len2) ? v2 : v1;

    int *res = calloc(max_len, sizeof(int));

    if (!res) return NULL;

    for (int i = 0; i < max_len; i++) {
        res[i] = largest[i];
    }
    for (int i = 0; i < min_len; i++) {
        res[i] += small[i];
    }
    return res;
}

int* merge (int *a1, int *a2, int len) {
    int *res = calloc(len * 2, sizeof(int));
    if (!res) return NULL;

    int i = 0, j = 0, k = 0;

    while (i < len && j < len) {
        if (a1[i] <= a2[j]) {
            res[k++] = a1[i++];
        } else {
            res[k++] = a2[j++];
        }
    }
    while (i < len) {
        res[k++] = a1[i++];
    }
    while (j < len) {
        res[k++] = a2[j++];
    }

    return res;
}

int* kth_largest(int *arr, int len, int k) {
    if (!arr || len <= 0 || k < 1 || k > len) return NULL;

    for (int i = 0; i < len; i++) {
        int count = 0;
        for (int j = 0; j < len; j++) {
            if (arr[j] > arr[i] || (arr[j] == arr[i] && j < i)) {
                count++;
            }
        }
        if (count == k - 1) {
            return &arr[i];
        }
    }
    return NULL;
}