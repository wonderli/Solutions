#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
typedef struct node{
    struct node *next;
    int val;
} Node;

typedef struct minStack{
    Node *top;
    struct minStack *min;
    int size;
    int minVal;
} MinStack;

Node *createNode(int data){
    Node *n = (Node *)malloc(sizeof(Node));
    n->next = NULL;
    n->val = data;
    return n;
}
MinStack *createMinStack(){
    MinStack *mStack = (MinStack *)malloc(sizeof(MinStack));
    mStack->top = NULL;
    mStack->size = 0;
    mStack->minVal = INT_MAX;
    mStack->min = (MinStack *)malloc(sizeof(MinStack));
    mStack->min->top = NULL;
    mStack->min->size = 0;
    mStack->min->minVal = INT_MAX; 
    return mStack;
}
void pushMinStack(MinStack *mStack, int data){
    Node *n = createNode(data);
    n->next = mStack->top;
    mStack->top = n;
    mStack->size++;
}
void push(MinStack *mStack, int data){
    if(mStack == NULL){
        mStack = createMinStack();
        mStack->top = createNode(data);
        mStack->minVal = data;
        mStack->size++;
        pushMinStack(mStack->min, data);
        return;
    }else{
        Node *n = createNode(data);
        n->next = mStack->top;
        mStack->top = n;
        if(data < mStack->minVal){
            mStack->minVal = data;
            pushMinStack(mStack->min, data);
        }
        mStack->size++;
    }
}
int pop(MinStack *mStack){
    if(mStack == NULL){
        printf("\nmStack is NULL!!!!\n");
        return -1;
    }
    Node *n = mStack->top;
    mStack->top = n->next;
    int ret = n->val;
    free(n);
    mStack->size--;
    if(n->val == mStack->minVal){
        Node *minTop = mStack->min->top;
        mStack->min->top = mStack->min->top->next;
        free(minTop);
        mStack->min->size--;
        mStack->minVal = mStack->min->top->val;
    }
    return ret;
}
void printStack(MinStack *mStack){
    if(mStack == NULL){
        printf("mStack is EMPTY!!!\n");
        return;
    }
    int size = mStack->size;
    Node *p = mStack->top;
    printf("Stack: ");
    while(size != 0){
        printf("%d->", p->val);
        p = p->next;
        size--;
    }
    printf("\n");
    printf("Min Stack: ");
    Node *mp = mStack->min->top;
    int msize = mStack->min->size;
    while(msize != 0){
        printf("%d->", mp->val);
        mp = mp->next;
        msize--;
    }
    printf("\n");
    printf("Min Value %d\n", mStack->minVal);
    printf("\n---------------------------------\n");
}



int main(){
    MinStack *mStack = createMinStack();
    push(mStack, 5);
    printStack(mStack);
    push(mStack, 4);
    printStack(mStack);
    push(mStack, 3);
    printStack(mStack);
    push(mStack, 2);
    printStack(mStack);
    push(mStack, 1);
    printStack(mStack);
    printf("POP %d\n", pop(mStack));
    printStack(mStack);
    printf("POP %d\n", pop(mStack));
    printStack(mStack);
    printf("POP %d\n", pop(mStack));
    printStack(mStack);
    printf("POP %d\n", pop(mStack));
    printStack(mStack);
    push(mStack, 4);
    printStack(mStack);
    push(mStack, 3);
    printStack(mStack);
    push(mStack, 2);
    printStack(mStack);

}
