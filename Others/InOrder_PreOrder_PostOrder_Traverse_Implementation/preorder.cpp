#include <iostream>
#include "node.h"
#include <stack>
using namespace std;
void preorder_recursive(Node *root){
    if(root == NULL) return;
    cout << root->data << " ";
    preorder_recursive(root->left);
    preorder_recursive(root->right);
}
void preorder_iterative(Node *root){
    stack<Node *> s;
    Node *curr = root;
    while(!s.empty()||curr){
        if(curr){
            cout << curr->data << " ";
            s.push(curr);
            curr = curr->left;
        }else{
            curr = s.top();
            s.pop();
            curr = curr->right;
        }
    }

}
int main(){
    Node *root = buildTestTree();
    preorder_recursive(root);
    cout << endl;
    preorder_iterative(root);
    cout << endl;
    return 0;
}
