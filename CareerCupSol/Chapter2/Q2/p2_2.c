#include "linklist.h"
Node *findkth(List *list, int k) {
    int i;
    if(list == NULL) return NULL;
    Node *current;
    Node *runner;
    current = list->head;
    runner = list->head;
    for(i = 0; i < k; i++) {
        if(runner == NULL) return NULL;
        runner = runner->next;
    }
    if(runner == NULL) return NULL;
    while(runner != NULL) {
        runner = runner->next;
        current = current->next;
    }
    return current;

}
int main() {
    List *list = createList();
    int size = 10;
    int i;
    int k = 9;
    for(i = 0; i < size; i++) {
        appendNode(list, i);
    }
    printList(list);
    Node *new = findkth(list, k);
    printf("\nNode data is %d\n", new->data);
    
    

}
