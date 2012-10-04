#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;

Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    return n;
}


int max_height_of_tree_recursive(Node *root){
    if(root == NULL) return 0;
    int left = max_height_of_tree_recursive(root->left);
    int right = max_height_of_tree_recursive(root->right);
    return left > right? left+1 : right+1;
}
Node *createTest(){
    Node *root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->right->left = createNode(4);
    root->right->right = createNode(5);
    return root;
}
int main(){
    Node *root = createTest();
    printf("%d\n", max_height_of_tree_recursive(root));
    return 0;
}
