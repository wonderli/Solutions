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

Node *buildBT(){
    Node *root = createNode(28);
    root->left = createNode(4);
    root->right = createNode(69);
    root->left->right = createNode(8);
    root->left->right->left = createNode(7);
    root->left->right->right = createNode(12);
    root->left->right->left->left = createNode(5);
    root->left->right->left->left->right = createNode(6);
    root->left->right->right->right = createNode(13);
    root->left->right->right->right->left = createNode(11);
    root->right->left = createNode(56);
    root->right->left->left = createNode(34);
    root->right->left->left->left = createNode(2);
    root->right->left->left->left->left = createNode(10);
    root->right->left->right = createNode(27);
    root->right->left->right->left = createNode(3);
    root->right->left->right->left->left = createNode(9);
    root->right->left->right->right = createNode(39);
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
void printLeftEdge(Node *n){
    if(!n) return;
    if(!n->left && !n->right) return;
    cout << n->data << " ";
    if(n->left){
        printLeftEdge(n->left);
    }else{
        printLeftEdge(n->right);
    }
}
void printRightEdge(Node *n){
    if(!n) return;
    if(!n->left && !n->right) return;
    if(n->right){
        printRightEdge(n->right);
    }else{
        printRightEdge(n->left);
    }
    cout << n->data << " ";
}
void printLeaves(Node *n){
    if(!n) return;
    printLeaves(n->left);
    if(!n->left && !n->right){
        cout << n->data << " ";
    }
    printLeaves(n->right);
}
void printEdges(Node *n){
    printLeftEdge(n);
    printLeaves(n);
    printRightEdge(n);
}

int main(){
    Node *root = buildBT();
    printPretty(root, 1, 5, cout);
    cout << endl;
    printEdges(root);
}
