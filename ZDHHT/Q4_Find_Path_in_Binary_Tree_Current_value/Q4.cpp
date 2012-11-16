//find all paths for the current value in a Binary Tree
#include <iostream>
#include <vector>
using namespace std;
typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;
Node *newNode(int value){
    Node *n = (Node *)malloc(sizeof(Node));
    n->data = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}


//       10
//      / \
//     5 12
//    / \
//   4   7
bool f(Node *root, int sum, vector<int> v, vector< vector<int> > &vlist){
    if((root == NULL) && sum == 0){
        vlist.push_back(v);
        return true;
    }
    if(root == NULL && sum != 0){
        return false;
    }
    int root_data = root->data;
    v.push_back(root->data);
    if(root_data == sum){
        vlist.push_back(v);
        return true;
    }
    f(root->left, sum - root_data, v, vlist);
    f(root->right, sum - root_data, v, vlist);
}




int main(){
    Node *root = newNode(10);
    root->left = newNode(5);
    root->right = newNode(12);
    root->left->left = newNode(4);
    root->left->right= newNode(7);
    vector<int> v;
    vector< vector<int> > vlist;
    int num  = 0;
    cin >> num;
    f(root, num, v, vlist);
    vector< vector<int> >::iterator listIter;
    vector<int>::iterator iter;
    for(listIter = vlist.begin(); listIter < vlist.end(); listIter++){
        for(iter = listIter->begin(); iter < listIter->end(); iter++){
            cout << *iter << " ";
        }
        cout << endl;
    }

    return 0;
}
