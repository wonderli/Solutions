#include <iostream>
#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <deque>
using namespace std;
typedef struct node {
    struct node *left;
    struct node *right;
    int data;
} Node;

Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    return n;
}

Node *buildBST(){
    Node *n[10];
    int i = 0;
    for(i = 0; i < 10; i++) {
        n[i] = createNode(i);
    }
    Node *root = n[5];
    root->left = n[3];
    root->right = n[8];
    root->left->left = n[1];
    root->left->right = n[4];
    root->left->left->left = n[0];
    root->left->left->right = n[2];
    root->right->left = n[7];
    root->right->right = n[9];
    root->right->left->left = n[6];
    return root;
}

int maxHeight(Node *root){
    if(!root) return 0;
    int left = maxHeight(root->left);
    int right = maxHeight(root->right);
    return (left > right)? left:right + 1;
}
string intToString(int val){
    ostringstream ss;
    ss << val;
    return ss.str();
}

void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<Node *> &nodesQueue, ostream &out){
    deque<Node *>::const_iterator iter = nodesQueue.begin();
    for(int i = 0; i < nodesInThisLevel/2; i++){
        out << ((i == 0) ? setw(strartLen - 1) : setw(nodeSpaceLen - 2)) << "" << ((*iter++) ? "/" : " ");
        out << setw(2*branchLen + 2) << "" << ((*iter++) ? "\\" : " ");
    }
    out << endl;
}
void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<Node *> &nodesQueue, ostream &out) {
    deque<Node *>::const_iterator iter = nodesQueue.begin();
    for(int i = 0; i < nodesInThisLevel; i++, iter++){
        out << ((i == 0) ? setw(startLen):setw(nodeSpaceLen)) << "" << ((*iter && (*iter)->left) ? setfill('_'): setfill(' '));
        out << setw(branchLen + 2) << ((*iter) ? intToString((*iter)->data):"");
        out << ((*iter && (*iter)->right) ? setfill('_') : setfill(' ')) << setw(branchLen) << "" << setfill(' ');
    }
    out << endl;
}


int main(){
    Node *root = buildBST();
}
