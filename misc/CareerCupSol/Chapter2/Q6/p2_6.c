#include <stdio.h>
#include <stdlib.h>
#include "linklist.h"
List *create_loop_list() {
    List *list = createList();
    int i, count;
    for(i = 0; i < 10; i++) {
        appendNode(list, i);
    }
    Node *current = list->head;
    Node *fast = list->head;
    count = 0;
    while(fast->next != NULL) {
        if(count != 4) {
            fast = fast->next;
            count++;
        }
        else
        break;
    }
    while(fast->next != NULL) {
        current = current->next;
        fast = fast->next;
    }
    fast->next = current;

//    printList(list);
    return list;
}
int detect_start(List *list) {
    int pos = 0;
    Node *slow = list->head;
    Node *fast = list->head;
    slow = slow->next;          /*To avoid the begin slow->data eq fast->data*/
    fast = fast->next->next;
    while((slow->data) != (fast->data)) {
        slow = slow->next;
        fast = fast->next->next;
    }
    slow = list->head;
    while((slow->data) != (fast->data)) {
        slow = slow->next;
        fast = fast->next;
        pos++;
    }
    return pos;
}

int main() {
    List *list = create_loop_list();
    int pos = detect_start(list);
    printf("The loop start is %d\n", pos);


}
