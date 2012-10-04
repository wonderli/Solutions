#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;

Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->left = NULL;
    n->right = NULL;
    n->data = data;
    return n;
}

Node *buildTestTree(){
    Node *root = createNode(10);
    root->left = createNode(5);
    root->left->left = createNode(1);
    root->left->right = createNode(7);
    root->right = createNode(15);
    root->right->left = createNode(13);
    root->right->right = createNode(20);
    return root;
}
