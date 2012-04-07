#include <stdio.h>
#include <stdlib.h>
#include "linklist.h"
List *linklist_add(List *list1, List *list2) {
    List *list = createList();
    Node *ptr1 = list1->head;
    Node *ptr2 = list2->head;
    int carry = 0;
    int data = 0;
    while(ptr1 != NULL && ptr2 != NULL) {
        data = ptr1->data + ptr2->data + carry;
        if(data >= 10) {
            carry = data / 10;
            data = data % 10;
        }
        appendNode(list, data);
        ptr1 = ptr1->next;
        ptr2 = ptr2->next;
    }
    if(ptr1 == NULL) {
        while(ptr2 != NULL) {
            data = ptr2->data;
            appendNode(list, data);
            ptr2 = ptr2->next;
        }
    }
    if(ptr2 == NULL) {
        while(ptr1 != NULL) {
            data = ptr1->data;
            appendNode(list, data);
            ptr1 = ptr1->next;
        }
    }
    return list;
}
int main() {
    List *list1 = createList();
    List *list2 = createList();
    appendNode(list1, 7);
    appendNode(list1, 1);
    appendNode(list1, 6);
    appendNode(list2, 5);
    appendNode(list2, 9);
    appendNode(list2, 2);

    printList(list1);
    printList(list2);
    List *newlist = linklist_add(list1, list2);
    printList(newlist);


    return 0;
}

