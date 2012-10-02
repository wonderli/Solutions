//Traverse Tree by Level, Queue Version
#include <stdio.h>
#include <stdlib.h>
#define MAX_Q_SIZE 500
typedef struct node {
    int data;
    struct node *left;
    struct node *right;
} Node;
Node **createQueue(int *front, int *rear){
    Node **queue = (Node **)malloc(sizeof(Node *)*MAX_Q_SIZE);
    *front = *rear = 0;
    return queue;
}
void enqueue(Node **queue, int *rear, Node *new_node){
    queue[*rear] = new_node;
    (*rear)++;
}
Node *dequeue(Node **queue, int *front){
    (*front)++;
    return queue[*front - 1];
}
Node *newNode(int data) {
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right= NULL;
    return n;
}
void printLevelNode(Node *root){
    int front = 0;
    int rear = 0;
    Node **queue = createQueue(&front, &rear);
    Node *tmp = root;
    while(tmp){
        printf("%d ->", tmp->data);
        if(tmp->left)
            enqueue(queue, &rear, tmp->left);
        if(tmp->right)
            enqueue(queue, &rear, tmp->right);
        tmp = dequeue(queue, &front);
    }
}
int main(){
    Node *root = newNode(1);
    root->left        = newNode(2);
    root->right       = newNode(3);
    root->left->left  = newNode(4);
    root->left->right = newNode(5);
    printf("Level Order traversal of binary tree is \n");
    printLevelNode(root);
    return 0;
}




