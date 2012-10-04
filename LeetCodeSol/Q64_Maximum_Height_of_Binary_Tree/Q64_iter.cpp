#include <stdio.h>
#include <stack>
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
//Post order
int max_height_of_tree_iteratative(Node *root){
    if(root == NULL) return 0;
    stack<Node *> s;
    s.push(root);
    Node *curr = root;
    Node *prev = NULL;
    int maxdepth = 0;
    while(!s.empty()){
        curr = s.top();
        if(!prev||prev->left == curr||prev->right == curr){
            if(curr->left) s.push(curr->left);
            else if(curr->right) s.push(curr->right);
        }else if(curr->left == prev){
            if(curr->right)
                s.push(curr->right);
        }else{
            s.pop();
        }
        prev = curr;
        if(s.size() > maxdepth){
            maxdepth = s.size();
        }
    }
    return maxdepth;
}
Node *createTest(){
    Node *root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->right->left = createNode(4);
    root->right->right = createNode(5);
    return root;
}
Node *buildTestTree(){
    Node *root = createNode(30);
    root->left = createNode(20);
    root->right = createNode(40);
    root->left->left = createNode(10);
    root->left->right = createNode(25);
    root->left->left->left = createNode(9);
    root->left->left->right = createNode(15);
    root->left->right->left = createNode(23);
    root->left->right->right = createNode(27);
    root->right->left = createNode(35);
    root->right->right = createNode(45);
    return root;
}

int main(){
    //Node *root = createTest();
    Node *root = buildTestTree();
    int depth = max_height_of_tree_iteratative(root);
    printf("%d\n", depth);
    return 0;
}
