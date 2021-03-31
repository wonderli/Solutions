#include <iostream>
#include "node.h"
#include <stack>
using namespace std;
void postorder_recursive(Node *root){
    if(root == NULL) return;
    postorder_recursive(root->left);
    postorder_recursive(root->right);
    cout << root->data << " ";
}
void postorder_iterative1(Node *root){
    stack<Node *> s;
    Node *curr = root;
    s.push(root);
    Node *prev = NULL;
    while(!s.empty()){
        Node *curr = s.top();
        if(!prev||prev->left == curr||prev->right == curr){
            if(curr->left) s.push(curr->left);
            else if(curr->right) s.push(curr->right);
            else {
                cout << curr->data << " ";
                s.pop();
            }
        } else if(curr->left == prev){
            if(curr->right) s.push(curr->right);
            else{
                cout << curr->data << " ";
                s.pop();
            }
        } else if(curr->right == prev){
            cout << curr->data << " ";
            s.pop();
        }
        prev = curr;
    }
}
void postorder_iterative2(Node *root){
    stack<Node *> s;
    Node *curr = root;
    s.push(root);
    Node *prev = NULL;
    while(!s.empty()){
        Node *curr = s.top();
        if(!prev||prev->left == curr||prev->right == curr){
            if(curr->left) s.push(curr->left);
            else if(curr->right) s.push(curr->right);
        } else if(curr->left == prev){
            if(curr->right) s.push(curr->right);
        } else {
            cout << curr->data << " ";
            s.pop();
        }
        prev = curr;
    }
}
int main(){
    Node *root = buildTestTree2();
    cout << "Post order" << endl;
    postorder_recursive(root);
    cout << endl;
    postorder_iterative1(root);
    cout << endl;
    postorder_iterative2(root);
    cout << endl;
}
