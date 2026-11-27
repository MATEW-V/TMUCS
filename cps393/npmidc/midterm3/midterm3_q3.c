#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node *next;
} node;

/*
    NAME:
    CSID:

    Q3: 3 marks)

    This function inserts a new node holding v into a linked list
    that is already sorted in ascending order. It returns the head
    of the list after the insertion.

    The new node must be placed so the list stays sorted. Duplicate
    values are allowed. If the list is empty, the new node becomes
    the whole list.

    Allocate the new node dynamically. You do not need to free the
    list at the end of main.

    Examples (each line shows the list after the insertion):
        insert 5 into (empty)  ->  5
        insert 2 into 5       ->  2 5
        insert 9 into 2 5     ->  2 5 9
        insert 5 into 2 5 9   ->  2 5 5 9
*/

node *insert_sorted (node *head, int v)
{
    // Your code here


    return head;   // change this
}

void print_list (node *head)
{
    node *p;
    if (head == NULL) {
        printf("(empty)\n");
        return;
    }
    for (p = head; p != NULL; p = p->next) {
        printf("%d", p->value);
        if (p->next != NULL) printf(" ");
    }
    printf("\n");
}

int main()
{
    node *head = NULL;

    head = insert_sorted(head, 5);
    print_list(head);    // should print: 5

    head = insert_sorted(head, 2);
    print_list(head);    // should print: 2 5

    head = insert_sorted(head, 9);
    print_list(head);    // should print: 2 5 9

    head = insert_sorted(head, 5);
    print_list(head);    // should print: 2 5 5 9

    head = insert_sorted(head, 1);
    print_list(head);    // should print: 1 2 5 5 9

    return 0;
}
