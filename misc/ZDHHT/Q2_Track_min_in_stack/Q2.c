#include <stdio.h>
#include <stdlib.h>
#define MAX_VALUE 99999
typedef struct node{
    struct node *next;
    int value;
} Node;
typedef struct stack{
    Node *top;
    struct stack *min_stack;
    int min_value;
} Stack;

Node *createNode(int value){
    Node *n = (Node *)malloc(sizeof(Node));
    n->value = value;
    n->next = NULL;
    return n;
}

Stack *createStack(){
    Stack *stack = (Stack *)malloc(sizeof(Stack));
    stack->top = NULL;
    stack->min_stack = (Stack *)malloc(sizeof(Stack));
    stack->min_stack->top = NULL;
    stack->min_stack->min_value = MAX_VALUE;
    stack->min_stack->min_stack = NULL;
    stack->min_value = MAX_VALUE;
    return stack;
}

int min(Stack *stack){
    if(stack == NULL) {
        perror("Stack is not exist");
        return -1;
    }
    return stack->min_value;
}

int push_min_stack(Stack *stack, int value) {
    if(stack == NULL) {
        perror("Stack is not exit");
        return -1;
    }
    Node *n = createNode(value);
    n->next = stack->top;
    stack->top = n;
    return 1;
}

void push(Stack *stack, int value) {
    Node *n = createNode(value);
    n->next = stack->top;
    stack->top = n;
    if(value < stack->min_value){
        stack->min_value = value;
        push_min_stack(stack->min_stack, stack->min_value);
    }
}
int pop_min_stack(Stack *min_stack){
    if(min_stack == NULL){
        perror("Stack does not exists");
        return -1;
    }
    Node *tmp = min_stack->top;
    min_stack->top = min_stack->top->next;
    free(tmp);
    int ret = min_stack->top->value;
    return ret;
}
int pop(Stack *stack) {
    if(stack == NULL){
        perror("Stack does not exists");
        return -1;
    }
    int ret = stack->top->value;

    Node *tmp = stack->top;
    if(stack->top->next){
        stack->top = stack->top->next;
    }else
    {
        stack->min_value = -1;
        printf("\nStack Empty\n");
        return -1;
    }
    free(tmp);

    if(ret == stack->min_value){
        int min = pop_min_stack(stack->min_stack);
        stack->min_value = min;
    }
    return ret;
}
int main(){
    Stack *stack = createStack();
    push(stack,3);
    push(stack, 4);
    push(stack, 2);
    push(stack, 1);
    pop(stack);
    printf("%d\n",min(stack));
    pop(stack);
    printf("%d\n",min(stack));
    pop(stack);
    printf("%d\n",min(stack));
    pop(stack);
    printf("%d\n",min(stack));
}
