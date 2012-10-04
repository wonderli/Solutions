#include <iostream>
#include "node.h"
#include <stack>
using namespace std;
void inorder_recursive(Node *root){
    if(root == NULL) return;
    inorder_recursive(root->left);
    cout << root->data << " ";
    inorder_recursive(root->right);
}
void inorder_iterative(Node *root){
    stack<Node *> s;
    //s.push(root);
    Node *curr = root;
    while(!s.empty()||curr){
        if(curr){
            s.push(curr);
            curr = curr->left;
        }else{
            curr = s.top();
            s.pop();
            cout << curr->data << " ";
            curr = curr->right;
        }
    }

}
int main(){
    Node *root = buildTestTree();
    //inorder_recursive(root);
    inorder_iterative(root);
}
