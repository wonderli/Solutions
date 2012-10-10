#include <iostream>
#include <stack>
#include <algorithm>
#define L2R 1
#define R2L 0
using namespace std;
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;
Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
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
void printZigZag(Node *root){
    stack<Node *> currLevel;
    stack<Node *> nextLevel;
    int direction = L2R;
    currLevel.push(root);
    while(!currLevel.empty()){
        Node *curr = currLevel.top();
        currLevel.pop();
        if(curr && (direction == L2R)){
            cout << curr->data << " ";
            nextLevel.push(curr->left);
            nextLevel.push(curr->right);
        }else if(curr && (direction == R2L)){
            cout << curr->data << " ";
            nextLevel.push(curr->right);
            nextLevel.push(curr->left);
        }
        if(currLevel.empty()){
            cout << endl;
            if(direction == L2R) direction = R2L;
            else direction = L2R;
            swap(currLevel, nextLevel);
        }
    }
}
int main(){
    Node *root = buildBST();
    printZigZag(root);
}
