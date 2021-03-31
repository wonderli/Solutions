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

typedef struct node{
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

typedef struct linklist{
    struct linklist *next;
    int data;
} List;

List *createList(int data){
    List *n = (List *)malloc(sizeof(List));
    n->next = NULL;
    n->data = data;
    return n;
}

List *buildList(){
    int size = 7;
    List *l[size];
    for(int i = 0; i < size; i++){
        l[i] = createList(i);
    }
    for(int i = 0; i < size - 1; i++){
        l[i]->next = l[i+1];
    }
    return l[0];
}

Node *createBSTFromList(List *&l, int start, int end){
    if(!l) return NULL;
    if(start > end) return NULL;
    int mid = (start + end)/2;
    Node *left = createBSTFromList(l, start, mid - 1);
    Node *parent = createNode(l->data);
    parent->left = left;
    l = l->next;
    parent->right = createBSTFromList(l, mid + 1, end);
    return parent;

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





int main(int argc, char *argv[]){
    int array[] = {0, 1, 2, 3, 4, 5, 6};
    List *l = buildList();
    Node *r = createBSTFromList(l, 0, 6);
    printPretty(r, 5, 1, cout);

}
