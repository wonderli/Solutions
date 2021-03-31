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

Node *buildTree(){
    Node *root = createNode(3);
    root->left = createNode(9);
    root->right = createNode(20);
    root->right->left = createNode(15);
    root->right->right = createNode(7);
    return root;
}

int maxHeight(Node *root){
    if(!root) return 0;
    int leftHeight = maxHeight(root->left);
    int rightHeight = maxHeight(root->right);
    return (leftHeight > rightHeight)? leftHeight:rightHeight + 1;
}
void printBTByLevelDFS(Node *root, int level){
    if(!root) return;
    if(level == 1){
        printf("%d ", root->data);
        return;
    }else {
        printBTByLevelDFS(root->left, level - 1);
        printBTByLevelDFS(root->right, level - 1);
    }
}
void printBT(Node *root){
    int i = 0;
    int Height = maxHeight(root);
    for(i = 1; i <= Height; i++){
        printBTByLevelDFS(root, i);
        printf("\n");
    }
}
int main(){
    Node *root = buildTree();
    printBT(root);
    return 0;
}

