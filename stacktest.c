#include "stack.h"
int main() {
    Stack *stack = createStack();
    int i = 0;
    int size = 10;
    for(i = 0; i < size; i++){
        push(stack, i);
    }
    displayStack(stack);
    displayStackTop(stack);
    pop(stack);
    displayStack(stack);
    displayStackTop(stack);
}
