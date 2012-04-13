#include<stdio.h>
#include<stdlib.h>
//#include "linklist.h"
#define FALSE 0 
#define TRUE 1
typedef struct stackNode {
    struct stackNode *next;
    int data;
}StackNode;

typedef struct stack{
    StackNode *top;
    StackNode *base;
    int size;
} Stack;
StackNode *createStackNode(int data){
    StackNode *node;
    node = (StackNode*)malloc(sizeof(StackNode));
    node->data = data;
    node->next = NULL;
    return node;
}
Stack *createStack() {
    Stack *stack;
    stack = (Stack*)malloc(sizeof(Stack));
    stack->top = NULL;
    stack->base = NULL;
    stack->size = 0;
    return stack;
}
int stackLength(Stack *stack) {
    return stack->size;
}
void push(Stack *stack, int data){
    StackNode *node = createStackNode(data);
    if(stack->size == 0) {
        stack->base = node;
        stack->top = node;
        stack->size++;
    }
    else {
        stack->top->next = node;
        stack->top = stack->top->next;
        stack->size++;
    }

}
int pop(Stack *stack){
	int data = 0;
    if(stack->size == 0) {
        return FALSE;
    }
    else {
        StackNode *current = stack->base;
		int i = 0;
		while(current->next != stack->top){
			current = current->next;
		}
			StackNode *tmp = current->next;
			data = tmp->data;
			stack->top = current;
            current->next = NULL;
			free(tmp);
		}
        stack->size--;
        return data;
}
void clearStack(Stack *stack){
    StackNode *current = stack->base;
    while(current->next != NULL) {
        StackNode *tmp = current;
        current = current->next;
        free(tmp);
    }
    stack->size = 0;
    stack->base = NULL;
    stack->top = NULL;
}
int getStackTop(Stack *stack){
	if(stack->size == 0) {
		return FALSE;
	} else {
		return stack->top->data;
	}
}
void displayStackTop(Stack *stack){
	int data = getStackTop(stack);
	if(data != FALSE) {
		printf("\nThe stack top is %d\n", getStackTop(stack));
	} else {
		printf("\nSTACK size is 0, no top\n");
	}
}
void displayStack(Stack *stack){
	StackNode *current = stack->base;
	printf("\n*********************\n");
	printf("Stack size is %d\n", stack->size);
	if(stack->size == 0) {
		printf("\nstack is empty\n");
		return;
	}
	while(current->next != NULL){
		printf("%d->", current->data);
		current = current->next;
	}
	printf("%d", current->data);
	printf("\n");
	printf("\n*********************\n");
}






