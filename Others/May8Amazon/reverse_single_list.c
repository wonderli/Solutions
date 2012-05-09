/*
This is from one of my friend interview question
Reverse a single list.
intput: 1->2->3->4
out: 4->3->2->1
*/
#include "linklist.h"
Node* reverse(Node *node) {
    Node *tmp;
    Node *pre = NULL;
    while(node!=NULL) {
        tmp = node->next;
        node->next = pre;
        pre = node;
        node = tmp;
    }
    return pre;
}
void print_single_list(Node *node) {
    printf("\n**************************************\n");
    while(node != NULL){
        printf("%d->", node->data);
        node = node->next;
    }
    printf("\n**************************************\n");
}
int main(){
    Node *n1 = createNode(1);
    Node *n2 = createNode(2);
    Node *n3 = createNode(3);
    Node *n4 = createNode(4);
    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = NULL;
    print_single_list(n1);
    Node *t = reverse(n1);
    print_single_list(t);
}

