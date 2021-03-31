#include "linklist.h"
int deleteDup(List *list) {
    if(list == NULL)
        return FALSE;
    Node *current;
    Node *runner;
    current = list->head;
    runner = list->head;
    Node *tmp;
    while(current != NULL) {
        while(runner->next != NULL) {
            if(current->data == runner->next->data) {
                tmp = runner->next;
                runner->next = runner->next->next;
                free(tmp);
            }
            else {
            runner = runner->next;
            }
        }
        current = current->next;
        runner = current;
    }
    return TRUE;
}
int main(){
    List *list = createList();
    int size = 100;
    int i;
    for(i = 0; i < size; i++) {
        appendNode(list, i%9);
    }
    printList(list);
    deleteDup(list);
    printList(list);
    

}
