#include <iostream>
#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <deque>
#include <iomanip>
#include <cmath>
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
    return (left > right)? left + 1:right + 1;
}
string intToString(int val){
    ostringstream ss;
    ss << val;
    return ss.str();
}

void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<Node *> &nodesQueue, ostream &out){
    deque<Node *>::const_iterator iter = nodesQueue.begin();
    for(int i = 0; i < nodesInThisLevel/2; i++){
        out << ((i == 0) ? setw(startLen - 1) : setw(nodeSpaceLen - 2)) << "" << ((*iter++) ? "/" : " ");
        out << setw(2 * branchLen + 2) << "" << ((*iter++) ? "\\" : " ");
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
void printLeaves(int indentSpace, int level, int nodesInThisLevel, const deque<Node *> &nodesQueue, ostream &out) {
    deque<Node *>::const_iterator iter = nodesQueue.begin();
    for(int i = 0; i  < nodesInThisLevel; i++, iter++){
        out << ((i==0) ? setw(indentSpace + 2) : setw(2*level+2)) << ((*iter) ? intToString((*iter)->data): "");
    }
    out << endl;
} 
void printPretty(Node *root, int level, int indentSpace, ostream &out){
    int h = maxHeight(root);
    int nodesInThisLevel = 1;
    int branchLen = 2 * ((int)pow(2.0, h) - 1) - (3 - level)*(int)pow(2.0, h - 1);
    int nodeSpaceLen = 2 + (level + 1) * (int)pow(2.0, h);
    int startLen = branchLen + (3 - level) + indentSpace;
    deque<Node*> nodesQueue;
    nodesQueue.push_back(root);
    for(int j = 1; j < h; j++){
        printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
        branchLen = branchLen/2 - 1;
        nodeSpaceLen = nodeSpaceLen/2 + 1;
        startLen = branchLen + (3 - level) + indentSpace;
        printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
        for(int i = 0; i < nodesInThisLevel; i++){
            Node *curr = nodesQueue.front();
            nodesQueue.pop_front();
            if(curr) {
                nodesQueue.push_back(curr->left);
                nodesQueue.push_back(curr->right);
            }else{
                nodesQueue.push_back(NULL);
                nodesQueue.push_back(NULL);
            }
        }
        nodesInThisLevel *= 2;
    }
        printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
        printLeaves(indentSpace, level, nodesInThisLevel, nodesQueue, out);
}



int main(){
    Node *root = buildBST();
    printPretty(root, 1, 5, cout);
}
