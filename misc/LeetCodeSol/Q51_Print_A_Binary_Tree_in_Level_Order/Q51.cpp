#include <iostream>
#include <stdlib.h>
#include <queue>
#include <algorithm>
using namespace std;
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

void printBTInLevelTwoQueue(Node *root){
    if(!root) return;
    queue<Node *> currentLevelNodes;
    queue<Node *> nextLevelNodes;
    currentLevelNodes.push(root);
    while(!currentLevelNodes.empty()){
        Node *curr = currentLevelNodes.front();
        currentLevelNodes.pop();
        if(curr){
            cout << curr->data << " ";
            nextLevelNodes.push(curr->left);
            nextLevelNodes.push(curr->right);
        }
        if(currentLevelNodes.empty()){
            cout << endl;
            swap(currentLevelNodes, nextLevelNodes);
        }
    }
}

void printBTInLevelOneQueue(Node *root){
    if(!root) return;
    queue<Node *> q;
    q.push(root);
    int currentLevelNodes = 1;
    int nextLevelNodes = 0;
    while(!q.empty()){
        Node *curr = q.front();
        q.pop();
        currentLevelNodes--;
        if(curr){
            cout << curr->data << " ";
            q.push(curr->left);
            q.push(curr->right);
            nextLevelNodes += 2;
        }
        if(currentLevelNodes == 0) {
            cout << endl;
            currentLevelNodes = nextLevelNodes;
            nextLevelNodes = 0;
        }
    }
}

int main(){
    Node *root = buildTree();
    printf("\nprint Binary Tree using Two Queue\n");
    printBTInLevelTwoQueue(root);
    printf("\nprint Binary Tree using One Queue\n");
    printBTInLevelOneQueue(root);
    return 0;
}
