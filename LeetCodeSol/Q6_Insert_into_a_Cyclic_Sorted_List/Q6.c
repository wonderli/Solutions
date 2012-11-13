#include <stdio.h>
#include <stdlib.h>
typedef struct node{
    int data;
    struct node *next;
} Node;
Node *createNode(int data){
    Node *node = (Node *)malloc(sizeof(Node));
    node->data = data;
    node->next = NULL;
    return node;
}
void printCyclicList(Node *root){
    Node *curr = root;
    printf("\n=============================\n");
    while(curr->next->data > curr->data){
        printf("%d->",curr->data);
        curr = curr->next;
    }
    printf("%d", curr->data);
    printf("\n=============================\n");
}
Node *createList(){
    Node *root = createNode(0);
    Node *curr = root; 
    int i = 1;
    int size = 5;
    for(i = 1; i < size; i++){
        curr->next = createNode(i);
        curr = curr->next;
    }
    for(i = size + 2; i < size*2; i++){
        curr->next = createNode(i);
        curr = curr->next;
    }
    curr->next = root;
    return root;
}
Node *insertCyclicList(Node *root, int data){
    Node *curr = root;
    Node *n = createNode(data);
    while(curr->next->data > curr->data){
        curr = curr->next;
    }
    Node *largest = curr;
    curr = root;
    if(data < root->data){
        largest->next = n;
        n->next = root;
        return n;
    }
    if(data > largest->data){
        largest->next = n;
        n->next = root;
        return root;
    }
    Node *prev = NULL;
    while(n->data > curr->data){
        prev = curr;
        curr = curr->next;
    }
    prev->next = n;
    n->next = curr;
    return root;
}
int main(){
    Node *root = createList();
    printCyclicList(root);
    root = insertCyclicList(root,-10);
    printCyclicList(root);
    return 0;
}
