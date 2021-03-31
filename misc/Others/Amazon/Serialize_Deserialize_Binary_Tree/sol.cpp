//serializable/serilizable binary tree
#include <iostream>
#include <fstream>
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
void inorder(Node *root){
    if(root == NULL) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}
void preorder(Node *root){
    if(root == NULL) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}

void serizable(Node *root, ostream &out){
    if(root == NULL){
        out << "# ";
        return;
    }
    out << root->data << " ";
    serizable(root->left, out);
    serizable(root->right, out);
}

bool readNextToken(int &token, ifstream &fin, bool &isNum){
    string s;
    fin >> s;
    if(s != "#"){
        isNum = true;
        char *str = const_cast<char *>(s.c_str());
        token = atoi(str);
        return true;
    }
    else{
        isNum = false;
        return false;
    }

}

void deserilizable(Node *&root, ifstream &fin){
    int token;
    char read;
    bool isNum;
    if(!readNextToken(token, fin, isNum)){
        return;
    }
    if(isNum){
        root = createNode(token);
        deserilizable(root->left, fin);
        deserilizable(root->right, fin);
    }
}
int main(){
    Node *root = buildBT();
    inorder(root);
    cout << endl;
    preorder(root);
    ofstream out("test.txt");
    cout << endl;
    serizable(root, out);
    out.close();
    Node *de;
    ifstream fin("test.txt");
    deserilizable(de, fin);
    inorder(de);
    cout << endl;
    preorder(de);
}
