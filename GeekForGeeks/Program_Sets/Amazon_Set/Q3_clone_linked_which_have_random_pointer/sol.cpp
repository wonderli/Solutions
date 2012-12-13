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
Node *buildRandomPointer(Node *n){
    Node *head = n;
    int pos = 4;
    Node *fast = head;
    Node *slow = head;
    while(pos > 0){
        fast = fast->next;
        pos--;
    }
    while(fast->next != NULL){
        fast = fast->next;
        slow = slow->next;
    }
    cout << "in build random pointer " << slow->value << endl;
    fast->next = slow;
    return head;
}
Node *detectCycle(Node *head){
    Node *slow = head;
    Node *fast = head;
    while(fast != NULL && fast->next != NULL){
        slow = slow->next;
        fast = fast->next;
        fast = fast->next;
        if(slow == fast){
            break;
        }
    }

    slow = head;
    while(slow != fast){
        slow = slow->next;
        fast = fast->next;
    }
    return slow;
}
Node *copyLinkList(Node *head){
    Node *pointed = detectCycle(head);
    Node *newhead = createNode(head->value);
    Node *newlist = newhead;
    Node *curr = head->next; 
    while(curr != pointed && curr != NULL){
        newlist->next = createNode(curr->value);
        newlist = newlist->next;
        curr = curr->next;
    }
    newlist->next = createNode(curr->value);
    curr = curr->next;
    newlist = newlist->next;
    while(curr != pointed){
        newlist->next = createNode(curr->value);
        newlist = newlist->next;
        curr = curr->next;
    }
    newlist->next = NULL;
    return newhead;
}
int main(){
    Node *head = buildLinkedlist();
    printList(head);
    head = buildRandomPointer(head);
    Node *newhead = copyLinkList(head);
    printList(newhead);

}
