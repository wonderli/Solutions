#include <iostream>
using namespace std;
typedef struct Node_{
    struct Node_ *left;
    struct Node_ *right;
    int data;
} Node;
int height(Node *root){
    if(root == NULL) return 0;
    int lh = height(root->left);
    int rh = height(root->right);
    return lh > rh ? lh + 1 : rh + 1;
}
Node *createNode(int i){
    Node *n = new Node;
    n->left = NULL;
    n->right = NULL;
    n->data = i;
    return n;
}
Node *buildBT(){
    Node *root = createNode(10);
    root->left = createNode(6);
    root->left->left = createNode(4);
    root->right = createNode(14);
    root->right->left = createNode(11);
    root->right->left->left = createNode(12);
    root->right->right = createNode(16);
    return root;
}
int main(){
    Node *root = buildBT();
    cout << height(root) << endl;
}
