#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
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
Node *buildLoop(Node *root){
    Node *slow = root;
    Node *fast = root;
    int step = 5;
    int i = 0;
    while(fast->next->next){
        slow = slow->next;
        fast = fast->next->next;
    }
    fast->next->next = slow;
    return root;
}
int checkLoop(Node *root){
    Node *slow = root;
    Node *fast = root;
    while(slow && fast && fast->next){
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast) return TRUE;
    }
    return FALSE;
}

int main(){
    Node *root = buildTestList();
    printList(root);
    root = buildLoop(root);
    printf("%d\n", checkLoop(root));
    Node *root2 = buildTestList();
    printf("%d\n", checkLoop(root2));
}
