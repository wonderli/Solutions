#include "util.h"
Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    return n;
}
Linklist *createListNode(int data){
    Linklist *n = (Linklist *)malloc(sizeof(Node));
    n->data = data;
    n->next = NULL;
    return n;
}
Node *buildBST(){
    Node *n[10];
    int i = 0;
    for(i = 0; i < 10; i++) {
        n[i] = createNode(i);
    }
    Node *root = n[5];
    root->left = n[3];
    root->right = n[8];
    root->left->left = n[1];
    root->left->right = n[4];
    root->left->left->left = n[0];
    root->left->left->right = n[2];
    root->right->left = n[7];
    root->right->right = n[9];
    root->right->left->left = n[6];
    return root;
}
Linklist *buildSingleLinklist(){
    int size = 10; 
    int i = 0;
    Linklist *n[size];
    for(i = 0; i < size; i++){
        n[i] = createListNode(i);
    }
    for(i = 1; i < size; i++){
        n[i - 1]->next = n[i];
    }
    return n[0];
}
void printLinkedList(Linklist *root){
    while(root->next != NULL){
        printf("%d->", root->data);
        root = root->next;
    }
    printf("%d\n", root->data);
}
int maxHeight(Node *root){
    if(!root) return 0;
    int left = maxHeight(root->left);
    int right = maxHeight(root->right);
    return (left > right)? left:right + 1;
}
