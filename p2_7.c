#include "linklist.h"
#include "stack.h"
int check_palindrome(List *list) {
    Node *slow = list->head;
    Node *fast = list->head;
    Stack *stack = createStack();
    int pop_data;
    while(fast != NULL && fast->next != NULL) {
        push(stack,slow->data);
        slow = slow->next;
        fast = fast->next->next;
    }
    //if linklist odd, igore middle element
    if(fast != NULL) {
        slow = slow->next;
    }
    while(slow->next != NULL) {
        pop_data = pop(stack);
        if(pop_data != slow->data){
            return FALSE;
        } else {
            slow = slow->next;
        }
    }
    return TRUE;
}
int main() {
    List *list = createList(list);
    int i = 0;
    int j = 1;
    int size = 9;
    int mid = 5;
    for(i = 0; i < size; i++) {
        if(i < mid) {
            appendNode(list, i);
        }else {
            appendNode(list, mid - j);
            j++;
        }
    }
    printList(list);
    int ret = check_palindrome(list);
    if(ret == TRUE) {
        printf("\nTRUE\n");
    }else {
        printf("\nFALSE\n");
    }
}
