#include <iostream>
#include <stack>
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
Node *mirror(Node *root){
    if(root == NULL) return NULL;
    Node *tmp = root->left;
    root->left = root->right;
    root->right = tmp;
    if(root->left){
        Node *left = mirror(root->left);
    }
    if(root->right){
        Node *right = mirror(root->right);
    }
    return root;
}
void printTree(Node *root){
    if(root == NULL) return;
    printTree(root->left);
    cout << root->data << " ";
    printTree(root->right);
}
void mirrorIterative(Node *root){
    if(root == NULL) return;
    stack<Node *> s;
    s.push(root);
    while(s.size()){
        Node *n = s.top();
        s.pop();
        Node *tmp = n->left;
        n->left = n->right;
        n->right = tmp;
        if(n->left){
            s.push(n->left);
        }
        if(n->right){
            s.push(n->right);
        }
    }
}
int main(){
    Node *root = buildTree();
    printTree(root);
    cout << endl;
    mirrorIterative(root);
    printTree(root);
    cout << endl;
    mirror(root);
    printTree(root);
    cout << endl;
}
