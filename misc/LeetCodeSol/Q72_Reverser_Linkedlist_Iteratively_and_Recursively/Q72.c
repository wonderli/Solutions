#include <stdio.h>
#include <stdlib.h>
typedef struct node{
    int data;
    struct node *next;
} Node;
Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->next = NULL;
    return n;
}
void print_list(Node *root) {
    while(root->next){
        printf("%d->", root->data);
        root = root->next;
    }
    printf("%d", root->data);
    printf("\n");
}
Node *reverse_list_iter(Node *root){
    if(!root) return NULL;
    Node *curr = root;
    Node *prev = NULL;
    while(curr){
        Node *next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
void reverse_list_recursive(Node **root){
    Node *first;
    Node *rest;
    if(*root == NULL) return;
    first = *root;
    rest = first->next;
    if(rest == NULL)
        return ;
    reverse_list_recursive(&rest);
    first->next->next = first;
    first->next = NULL;
    *root = rest;
}
int main(){
    Node *root = createNode(1);
    Node *n1 = createNode(2);
    Node *n2 = createNode(3);
    Node *n3 = createNode(4);
    Node *n4 = createNode(5);
    Node *n5 = createNode(6);
    Node *n6 = createNode(7);
    root->next = n1;
    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;
    n5->next = n6;
    n6->next = NULL;
    print_list(root);
    reverse_list_recursive(&root);
    print_list(root);
    //Node *rev = reverse_list_iter(root);
    //print_list(rev);

    return 0;
}
