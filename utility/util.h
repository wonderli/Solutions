#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;
typedef struct linklist{
    struct linklist *next;
    int data;
} Linklist;
Node *createNode(int);
Linklist *createListNode(int);
Node *buildBST();
Linklist *buildSingleLinklist();
void printLinkedList(Linklist *);
int maxHeight(Node *);

