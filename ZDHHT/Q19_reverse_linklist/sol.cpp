#include <iostream>
#include <cstdlib>
using namespace std;
typedef struct Node_{
    struct Node_ *next;
    int data;
} Node;

Node *buildLinklist(){
    int size = 10;
    Node *root = new Node;
    root->data = 0;
    root->next = NULL;
    Node *curr = root;
    for(int i = 1; i < size; i++){
        Node *n = new Node;
        n->data = i;
        curr->next = n;
        curr = n;
    }
    return root;
}

void printList(Node *root){
    cout << endl;
    Node *curr = root;
    while(curr != NULL){
        cout << curr->data << "->";
        curr = curr->next;
    }
    cout << endl;
}
Node *reverseLinklist(Node *root){
    Node *prev = NULL;
    Node *curr = root;
    while(curr != NULL){
        Node *tmp = curr->next;
        curr->next = prev;
        prev = curr;
        curr = tmp;
    }
    return prev; 
}

int main(){
    Node *root = buildLinklist();
    printList(root);
    Node *reverse = reverseLinklist(root);
    printList(reverse);
}


