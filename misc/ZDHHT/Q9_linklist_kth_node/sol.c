#include <stdio.h>
#include <stdlib.h>
typedef struct node{
    struct node *next;
    int data;
} Node;
Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->next = NULL;
    n->data = data;
    return n;
}
void printList(Node *root){
    while(root->next != NULL){
        printf("%d -> ", root->data);
        root = root->next;
    }
    printf("\n");
}
void findKth(Node *root, int k){
    if(root == NULL){
        printf("Error\n");
        return;
    }
    Node *fast = root;
    Node *slow = root;
    int i = 0;
    while(i < k){
        fast = fast->next;
        i++;
    }
    while(fast->next != NULL){
        fast = fast->next;
        slow = slow->next;
    }
    printf("%d\n", slow->data);
    
}
int main(){
    int size = 10;
    Node *n[size];
    int i = 0;
    n[0] = createNode(0);
    Node *root = n[0];
    for(i = 1; i < size; i++){
        n[i] = createNode(i);
        n[i-1]->next = n[i];
    }
    printList(root);
    int k = 2;
    findKth(root, k);
    
}
