#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *next;
    struct Node *prev;
} Node;

Node *add(Node *curr, int val) {
    Node *n = malloc(sizeof(Node));
    if (!n) exit(1);
    n->val = val;

    if (curr == NULL) {
        n->next = n->prev = n;
        return n;
    }

    n->next = curr;
    n->prev = curr->prev;
    curr->prev->next = n;
    curr->prev = n;

    return n->next;
}

int main() {
    return -1;
}