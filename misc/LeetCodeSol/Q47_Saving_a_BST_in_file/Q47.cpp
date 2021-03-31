#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <climits>
#include <string>
#include <deque>
#include <iomanip>
#include <cmath>

using namespace std;
struct Node {
    struct Node *left;
    struct Node *right;
    int data;
    Node(int data){
        this->left = NULL;
        this->right = NULL;
        this->data = data;
    }
};
//use pre order to reconstruct tree.
void constructBST(int min, int max, int &val, Node *&n, ifstream &s){
    if(min < val && max > val){
        int data = val;
        n = new Node(data); 
        if(s >> val){
            constructBST(min, data, val, n->left, s);
            constructBST(data, max, val, n->right, s);
        }
    }
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

void printBranches(int branchLen, int NodeSpaceLen, int startLen, int NodesInThisLevel, const deque<Node *> &NodesQueue, ostream &out){
    deque<Node *>::const_iterator iter = NodesQueue.begin();
    for(int i = 0; i < NodesInThisLevel/2; i++){
        out << ((i == 0) ? setw(startLen - 1) : setw(NodeSpaceLen - 2)) << "" << ((*iter++) ? "/" : " ");
        out << setw(2 * branchLen + 2) << "" << ((*iter++) ? "\\" : " ");
    }
    out << endl;
}
void printNodes(int branchLen, int NodeSpaceLen, int startLen, int NodesInThisLevel, const deque<Node *> &NodesQueue, ostream &out) {
    deque<Node *>::const_iterator iter = NodesQueue.begin();
    for(int i = 0; i < NodesInThisLevel; i++, iter++){
        out << ((i == 0) ? setw(startLen):setw(NodeSpaceLen)) << "" << ((*iter && (*iter)->left) ? setfill('_'): setfill(' '));
        out << setw(branchLen + 2) << ((*iter) ? intToString((*iter)->data):"");
        out << ((*iter && (*iter)->right) ? setfill('_') : setfill(' ')) << setw(branchLen) << "" << setfill(' ');
    }
    out << endl;
}
void printLeaves(int indentSpace, int level, int NodesInThisLevel, const deque<Node *> &NodesQueue, ostream &out) {
    deque<Node *>::const_iterator iter = NodesQueue.begin();
    for(int i = 0; i  < NodesInThisLevel; i++, iter++){
        out << ((i==0) ? setw(indentSpace + 2) : setw(2*level+2)) << ((*iter) ? intToString((*iter)->data): "");
    }
    out << endl;
} 
void printPretty(Node *root, int level, int indentSpace, ostream &out){
    int h = maxHeight(root);
    int NodesInThisLevel = 1;
    int branchLen = 2 * ((int)pow(2.0, h) - 1) - (3 - level)*(int)pow(2.0, h - 1);
    int NodeSpaceLen = 2 + (level + 1) * (int)pow(2.0, h);
    int startLen = branchLen + (3 - level) + indentSpace;
    deque<Node*> NodesQueue;
    NodesQueue.push_back(root);
    for(int j = 1; j < h; j++){
        printBranches(branchLen, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue, out);
        branchLen = branchLen/2 - 1;
        NodeSpaceLen = NodeSpaceLen/2 + 1;
        startLen = branchLen + (3 - level) + indentSpace;
        printNodes(branchLen, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue, out);
        for(int i = 0; i < NodesInThisLevel; i++){
            Node *curr = NodesQueue.front();
            NodesQueue.pop_front();
            if(curr) {
                NodesQueue.push_back(curr->left);
                NodesQueue.push_back(curr->right);
            }else{
                NodesQueue.push_back(NULL);
                NodesQueue.push_back(NULL);
            }
        }
        NodesInThisLevel *= 2;
    }
        printBranches(branchLen, NodeSpaceLen, startLen, NodesInThisLevel, NodesQueue, out);
        printLeaves(indentSpace, level, NodesInThisLevel, NodesQueue, out);
}



int main(){
    vector<int> v;
    int n;
    ifstream infile("tree.txt");
    int min = INT_MIN;
    int max = INT_MAX;
    Node *root = NULL;
    int val = 0;
    infile >> val;
    constructBST(min, max, val, root, infile);
    printPretty(root, 1, 5, cout);
    return 0;
}


