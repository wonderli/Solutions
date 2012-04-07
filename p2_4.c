#include <stdio.h>
#include <stdlib.h>
#include "linklist.h"
void partition(List *list, int pivot) {
    Node *current = list->head;
    Node *runner = list->head;
    while(runner != NULL) {
        if(runner->data > pivot) {
            runner = runner->next;
        }
        else {
            int tmp = current->data;
            current->data = runner->data;
            runner->data = tmp;
            if(runner->next != NULL) {
                runner = runner->next;
                current = current->next;
            }
            else break;
        }

    }
//    if(runner->data < current->data) {
//        int tmp = current->data;
//            current->data = runner->data;
//            runner->data = tmp;
//
//    }

}

int main() {
    List *list = createList();
    int size = 20;
    int i;
    for(i = size; i > 0; i--) {
        appendNode(list, rand()%7);
    }
    printList(list);
    printf("\nAfter partation \n");
    partition(list, 3);
    printList(list);

    

    return 0;
}
