//  
//  Convert a BST to a Binary Tree such that sum of all greater keys is added to every key
//  January 1, 2013
//
#include <iostream>
using namespace std;
typedef struct Node_{

    struct Node_ *left;

    struct Node_ *right;

    int data;

} Node;

Node *createNode(int data){

    Node *n = new Node;

    n->left = NULL;

    n->right = NULL;

    n->data = data;

    return n;

}

void inorder(Node *root){

    if(root == NULL) return;

    inorder(root->left);

    cout << root->data << " ";

    inorder(root->right);

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

void updateBinaryTree(Node *n, int &sum){
    if(n == NULL) return;
    updateBinaryTree(n->right, sum);
    sum = sum + n->data;
    n->data = sum;
    updateBinaryTree(n->left, sum);
}

int main(){
    //Node *root = createNode(5);
    //root->left = createNode(2);
    //root->right = createNode(13);
    Node *root = buildBT();
    inorder(root);
    int sum = 0;
    updateBinaryTree(root, sum);
    cout << endl;
    inorder(root);
    cout << endl;
}


