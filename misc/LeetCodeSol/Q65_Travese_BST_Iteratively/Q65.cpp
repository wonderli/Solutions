#include <iostream>
#include <stack>
#include <stdlib.h>
using namespace std;
typedef struct node{
    struct node *left;
    struct node *right;
    int data;
} BST;

void inorder_traverse_iterative(BST *root){
    stack<BST *> s;
    BST *current = root;
    bool done = false;
    while(!done){
        if(current){
            s.push(current);
            current = current->left;
        } else {
            if(s.empty()) {
                done = true;
            }else {
                current = s.top();
                s.pop();
                cout << current->data << " ";
                current = current->right;
            }
        }
    }
    cout<<"finish"<<endl;
}
BST *createBSTNode(int data){
    BST *n = (BST *)malloc(sizeof(BST));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    return n;
}

int main(){
    BST *root = createBSTNode(10);
    root->left = createBSTNode(5);
    root->left->left = createBSTNode(1);
    root->left->right = createBSTNode(7);
    root->right = createBSTNode(15);
    root->right->left = createBSTNode(13);
    root->right->right = createBSTNode(20);
    inorder_traverse_iterative(root);
    return 0;
}
