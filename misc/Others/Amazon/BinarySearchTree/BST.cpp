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
void inorder(Node *root){
    if(root == NULL) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}
void insertNode(Node *root, int key, Node *parent, bool isLeft){
    if(root == NULL){
        root = createNode(key);
        if(isLeft == true){
            parent->left = root;
        }else if(isLeft == false){
            parent->right = root;
        }
    }
    if(key > root->data){
        insertNode(root->right, key, root, false);
    }else if(key < root->data){
        insertNode(root->left, key, root, true);
    }
}
void removeNode(Node *root, int key, Node *parent, bool isLeft){
    if(root == NULL) {
        return;
    }
    if(key < root->data){
        removeNode(root->left, key, root, true);
    }else if(key > root->data){
        removeNode(root->right, key, root, false);
    }else if(key == root->data){
        if(root->left == NULL && root->right == NULL){
            if(isLeft){
                parent->left = NULL;
                cout << "TEST" << endl;
                free(root);
            }else{
                parent->right = NULL;
                free(root);
            }
        }else if(root->left != NULL && root->right == NULL){
            Node *curr = root;
            if(isLeft){
                parent->left = root->left;
            }else {
                parent->right = root->left;
            }
            free(curr);
        }else if(root->right != NULL){
            Node *curr = root->right;
            Node *tmp = root->right;
            while(curr->left){
                curr = curr->left;
            }
            if(isLeft){
                parent->left = curr;
                free(root);
            }else{
                parent->right = curr;
                free(root);
            }
        }
    }
}
int main(){
    Node *root = createNode(30);
    inorder(root);
    cout << endl;
    insertNode(root, 25, NULL, false);
    inorder(root);
    cout << endl;
    insertNode(root, 35, NULL, false);
    insertNode(root, 20, NULL, false);
    insertNode(root, 70, NULL, false);
    insertNode(root, 55, NULL, false);
    insertNode(root, 65, NULL, false);
    insertNode(root, 57, NULL, false);
    inorder(root);
    cout << endl;
    removeNode(root, 55, NULL, false);
    inorder(root);
    cout << endl;
}



