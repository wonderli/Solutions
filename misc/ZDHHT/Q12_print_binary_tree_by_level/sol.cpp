#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;
typedef struct node{
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
    Node *root = createNode(8);
    root->left = createNode(6);
    root->right = createNode(10);
    root->left->left = createNode(5);
    root->left->right = createNode(7);
    root->right->left = createNode(9);
    root->right->right = createNode(11);
    return root;
}

void printLevel(Node *root){
    stack<Node *> curr;
    stack<Node *> next;
    curr.push(root);
    while(!curr.empty()){
        Node *n = curr.top();
        curr.pop();
        cout << n->data << " ";
        if(n->left){
            next.push(n->left);
        }
        if(n->right){
            next.push(n->right);
        }
        if(curr.empty() && !next.empty()){
            cout << endl;
            swap(curr, next);
        }
    }
    cout << endl;

}
int main(){
    Node *root = buildTree();
    printLevel(root);
}
