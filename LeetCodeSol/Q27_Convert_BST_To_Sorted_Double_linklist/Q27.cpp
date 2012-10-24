#include <iostream>
using namespace std;
class node {
    public:
        node *left;
        node *right;
        int data;
        node(int n){
            left = NULL;
            right = NULL;
            data = n;
        }
};
node *buildTree(){
    node *root = new node(50);
    root->left = new node(30);
    root->right = new node(70);
    root->left->left = new node(10);
    root->left->right = new node(35);
    root->right->left = new node(65);
    root->right->left->right = new node(67);
    root->right->right = new node(80);
    return root;
}

node *dlistFromBST(node *p, bool isRight){
    if(!p) return NULL;
    node *leftChild = NULL;
    node *rightChild = NULL;
    if(p->left){
        leftChild = dlistFromBST(p->left, false);
    }
    if(leftChild){
        leftChild->right = p;
        p->left = leftChild;
    }
    if(p->right){
        rightChild = dlistFromBST(p->right, true);
    }
    if(rightChild){
        rightChild->left = p;
        p->right = rightChild;
    }
    node *tmp = p;
    if(isRight){
        while(tmp->left)
            tmp = tmp->left;
    }else{
        while(tmp->right)
            tmp = tmp->right;
    }
    return tmp;
}
node *createDlist(node *root){
    return dlistFromBST(root, true);
}

void printDlist(node *p){
    while(p->right){
        cout << p->data << "->";
        p = p->right;
    }
    cout << endl;
    while(p->left){
        cout << p->data << "->";
        p = p->left;
    }
}

int main(){
    node *root = buildTree();
    node *p = createDlist(root);
    printDlist(p);

}


