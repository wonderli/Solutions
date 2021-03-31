#include <stdio.h>
#include <stdlib.h>
#include "linklist.h"
void delete_node(List *list, Node *node) {
    Node *current;
    current = list->head;
    while(current->next != NULL) {
        if(current->data == node->data) {
            int tmp = current->data;
            current->data = current->next->data;
            current->next->data = tmp;
            Node *next = current->next;
            current->next = current->next->next;
            free(next);
        }
        current = current->next;
    }
}
int main() {
    List *list = createList();
    int size = 10;
    int i;
    for(i = 0; i < size; i++) {
        appendNode(list, i%9);
    }
    Node *node = createNode(3);
    printList(list);
    delete_node(list, node);
    printList(list);
    


    return 0;
}
