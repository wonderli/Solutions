//delete linklist node in O1 time
#include <iostream>
using namespace std;
typedef struct Node_{

    struct Node_ *next;

    int value;

} Node;

Node *createNode(int data){

    Node *n = new Node;

    n->next = NULL;

    n->value = data;

    return n;

}

Node *buildLinkedlist(){

    srand(time(NULL));

    int r = 0;

    int size = 10;

    Node *head = createNode(rand()%100 + 1);

    Node *curr = head;

    Node *n = NULL;

    while(size >0){

        r = rand()%100 + 1;

        n = createNode(r);

        curr->next = n;

        curr = n;

        size--;

    }

    return head;

}

void printList(Node *root){

    Node *ptr = root;

    printf("\n************************\n");

    while(ptr->next != NULL) {

        printf("%d->", ptr->value);

        ptr = ptr->next;

    }

    printf("\n************************\n");

}
void deleteNode(Node *root, Node *n){
    if(n->next != NULL){
        Node *tmp = n->next;
        n->value = tmp->value;
        n->next = tmp->next;
        delete tmp;
        tmp = NULL;
    }else{
        Node *curr = root;
        while(curr->next != n){
            curr = curr->next;
        }
        curr->next = NULL;
        delete n;
        n = NULL;
    }
}
Node *findNode(Node *root, int pos){
    Node *curr = root;
    int i = 0;
    while(i < pos){
        curr = curr->next;
        i++;
    }
    return curr;
}
int main(){
    Node *root = buildLinkedlist();
    printList(root);
    Node *n = findNode(root, 3);
    cout << n->value << endl;
    deleteNode(root, n);
    printList(root);
    n = findNode(root, 9);
    deleteNode(root, n);
    printList(root);
}
