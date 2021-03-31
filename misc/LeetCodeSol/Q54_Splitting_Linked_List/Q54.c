#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    struct node *next;
    int data;
} Node;
Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->next = NULL;
    n->data = data;
    return n;
}
Node *buildTestList(){
    int size = 12;
    Node *n[size];
    int i = 0;
    for(i = 0; i < size; i++) {
        n[i] = createNode(i);
    }
    i = 0;
    while(i < size - 1){
        n[i]->next = n[i+1];
        i++;
    }
    return n[0];
}
void printList(Node *root){
    while(root->next->next){
        printf("%d->", root->data);
        root = root->next;
    }
    printf("%d->", root->data);
    printf("%d \n", root->next->data);
}
void frontBackList(Node *root, Node **front, Node **back){
    if(!root) return;
    Node *front_last_node = NULL;
    Node *slow = root;
    Node *fast = root;
    while(fast){
        front_last_node = slow;
        slow = slow->next;
        fast = (fast->next) ? fast->next->next : NULL;
    }
    front_last_node->next = NULL;
    *front = root;
    *back = slow;
}
int main(){
    Node *n = buildTestList();
    printList(n);
    Node **front = (Node **)malloc(sizeof(Node *));
    Node **back = (Node **)malloc(sizeof(Node *));
    frontBackList(n, front, back);
    printList(*front);
    printList(*back);

}
