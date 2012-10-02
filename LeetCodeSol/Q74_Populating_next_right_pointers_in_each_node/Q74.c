#include <stdio.h>
#include <stdlib.h>
typedef struct node{
    struct node *left;
    struct node *right;
    struct node *nextRight;
    int data;
} Node;
void connect1(Node *p){
    if(p == NULL) return;
    if(p->left == NULL || p->right == NULL) return;
    Node *p1 = p;
    Node *right_slibing = NULL;
    while(p1){
        if(p1->nextRight) right_slibing = p1->nextRight->left;
        else right_slibing = NULL;
        if(p1->left && p1->right){
            p1->left->nextRight = p1->right;
            p1->right->nextRight = right_slibing;
        }
        if(p1->right){
            p1 = p1->right;
        }else break;
        
    }
    connect1(p->left);
}
void connect2 (Node *p) {
    if(p == NULL) return;
    if(p->left) p->left->nextRight = p->right;
    if(p->right) p->right->nextRight = p->nextRight ? p->nextRight->left:NULL;
    connect2(p->left);
    connect2(p->right);
}
Node *create_node(int data) {
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    n->nextRight = NULL;
    return n;
}
void print_result(Node *root){
    if(root == NULL) return ;
    if(root->nextRight == NULL){
        printf("%d->NULL\n", root->data);
    }
    else{
        printf("%d->%d\n", root->data, root->nextRight->data);
    }
    print_result(root->left);
    print_result(root->right);
    return;
}
int main(){
    Node *root = create_node(1);
    root->left = create_node(2);
    root->right = create_node(3);
    root->left->left = create_node(4);
    root->left->right = create_node(5);
    root->right->left = create_node(6);
    root->right->right = create_node(7);
    //connect1(root);
    connect2(root);
    print_result(root);
}
