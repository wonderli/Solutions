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
bool findAncestor(Node *root, Node *&find, int target){
    if(root == NULL) return false;
    if(root->data == target) return true;
    if(findAncestor(root->left, find, target) || findAncestor(root->right, find, target)){
        if(root->left->data == target || root->right->data == target){
            find = root;
            return true;
        }
    }
    return false;

}

int main(){
    Node *root = buildBT();
    Node *find = NULL;
    findAncestor(root,find,14);
    cout << find->data << endl;

}
