#include <iostream>
#include <stack>
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
void inorderIterative(Node *root){
    stack<Node *> s;
    Node *curr = root;
    bool done = false;
    while(!done){
        if(curr){
            s.push(curr);
            curr = curr->left;
        }else{
            if(s.empty()){
                done = true;
            }else{
                curr = s.top();
                s.pop();
                cout << curr->data << " ";
                curr = curr->right;
            }
        }
    }
}
void preorder(Node *root){
    if(root == NULL) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}
void preorderIterative(Node *root){
    if(root == NULL) return;
    stack<Node *> s;
    Node *curr = root;
    s.push(curr);
    while(!s.empty()){
        curr = s.top();
        s.pop();
        cout << curr->data << " ";
        if(curr->right){
            s.push(curr->right);
        }
        if(curr->left){
            s.push(curr->left);
        }
    }
}
void postorder(Node *root){
    if(root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    cout << root->data << " ";
}
void postordeIterative(Node *root){
    if(root == NULL) return;
    stack<Node *> s;
    Node *curr = root;
    Node *prev = NULL;
    s.push(root);
    while(!s.empty()){
        curr = s.top();
        if(!prev || prev->left == curr || prev->right == curr){
            if(curr->left){
                s.push(curr->left);
            }else if(curr->right){
                s.push(curr->right);
            }
        }else if(curr->left == prev){
            if(curr->right)
                s.push(curr->right);
        }else {
            cout << curr->data << " ";
            s.pop();
        }
        prev = curr;
    }
}
void postOrderTwoStack(Node *root){
    if(root == NULL) return;
    stack<Node *> s;
    stack<Node *> output;
    Node *curr = root;
    s.push(root);
    while(!s.empty()){
        curr = s.top();
        output.push(curr);
        s.pop();
        if(curr->left){
            s.push(curr->left);
        }
        if(curr->right){
            s.push(curr->right);
        }
    }
    while(!output.empty()){
        cout << output.top()->data << " ";
        output.pop();
    }
}
int maxDeep(Node *root){
    if(root == NULL) return 0;
    return max(maxDeep(root->left), maxDeep(root->right)) + 1;
}
Node *minValue(Node *root){
    Node *curr = root;
    while(curr->left != NULL){
        curr = curr->left;
    }
    return curr;
}
Node *findSuccessor(Node *root, Node *n){
    if(n->right != NULL){
        return minValue(n->right);
    }
    Node *succ = NULL;
    while(root != NULL){
        if(n->data < root->data){
            succ = root;
            root = root->left;
        }else if(n->data > root->data){
            root = root->right;
        }else
            break;
    }
    return succ;

}
int main(){
    Node *root = buildBT();
    inorder(root);
    cout << endl;
    inorderIterative(root);
    cout << endl;
    preorder(root);
    cout << endl;
    preorderIterative(root);
    cout << endl;
    postorder(root);
    cout << endl;
    postordeIterative(root);
    cout << endl;
    postOrderTwoStack(root);
    cout << endl;
    cout << maxDeep(root) << endl;
    Node *n = root->right->left->left;
    Node *succ = findSuccessor(root, n);
    cout << succ->data << endl;
}



