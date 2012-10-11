#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;
Node *createNode(int);
Node *buildBST();
int maxHeight(Node *);

