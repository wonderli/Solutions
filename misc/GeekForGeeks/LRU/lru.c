// LRU
// 1) A Queue implemented using a doubly linked list. The maximum size will equal to the total number of frames available(cache size)
// 2) A hash with page number as key and address of the corresponding queue node as value.
// When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it infront of the queue.
// If the rquired page is not in the memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, we remove a node from the rear of queue
#include <stdio.h>
#include <stdlib.h>
typedef struct QNode {
    struct QNode *prev, *next;
    unsigned int pageNumber;
} QNode;
typedef struct Queue {
    unsigned int count;
    unsigned int numberOfFrames;
    QNode *front, *rear;
} Queue;
typedef struct Hash {
    int capacity;
    QNode* *array;
} Hash;
QNode *newNode(unsigned int pageNumber){
    QNode *temp = (QNode *)malloc(sizeof(QNode));
    temp->pageNumber = pageNumber;
    temp->prev = temp->next = NULL;
    return temp;
}
Queue *createQueue(int numberOfFrames){
    Queue *queue = (Queue *)malloc(sizeof(Queue));
    queue->count = 0;
    queue->front = queue->rear = NULL;
    queue->numberOfFrames = numberOfFrames;
    return queue;
}
Hash *createHash(int capacity){
    Hash *hash = (Hash *)malloc(sizeof(Hash));
    hash->capacity = capacity;
    hash->array = (QNode **)malloc(hash->capacity * sizeof(QNode *));
    int i;
    for(i = 0; i < hash->capacity; i++){
        hash->array[i] = NULL;
    }
    return hash;
}
int AreAllFramesFull(Queue *queue){
    return queue->count == queue->numberOfFrames;
}
int isQueueEmpty(Queue *queue){
    return queue->rear == NULL;
}
void dequeue(Queue *queue){
    if(isQueueEmpty(queue))
        return;
    if(queue->front == queue->rear)
        queue->front = NULL;
    QNode *temp = queue->rear;
    queue->rear =queue->rear->prev;
    if(queue->rear)
        queue->rear->next = NULL;
    free(temp);
    queue->count--;
}
void Enqueue(Queue *queue, Hash *hash, unsigned int pageNumber){
    if(AreAllFramesFull(queue)){
        hash->array[queue->rear->pageNumber] = NULL;
        dequeue(queue);
    }
    QNode *temp = newNode(pageNumber);
    temp->next = queue->front;
    if(isQueueEmpty(queue)){
        queue->rear = queue->front = temp;
    }else{
        queue->front->prev = temp;
        queue->front = temp;
    }
    hash->array[pageNumber] = temp;
    queue->count++;
}
void ReferencePage(Queue *queue, Hash *hash, unsigned int pageNumber){
    QNode *reqPage = hash->array[pageNumber];
    if(reqPage == NULL){
        Enqueue(queue, hash, pageNumber);
    }else if(reqPage != queue->front){
        reqPage->prev->next = reqPage->next;
        if(reqPage->next){
            reqPage->next->prev = reqPage->prev;
        }
        if(reqPage == queue->rear){
            queue->rear = reqPage->prev;
            queue->rear->next = NULL;
        }
        reqPage->next = queue->front;
        reqPage->prev = NULL;
        reqPage->next->prev = reqPage;
        queue->front = reqPage;
    }
}
int main(){
    Queue *q =createQueue(4);
    Hash *hash = createHash(10);
    ReferencePage(q, hash, 1);
    ReferencePage(q, hash, 2);
    ReferencePage(q, hash, 3);
    ReferencePage(q, hash, 1);
    ReferencePage(q, hash, 4);
    ReferencePage(q, hash, 5);
    printf("%d ", q->front->pageNumber);
    printf("%d ", q->front->next->pageNumber);
    printf("%d ", q->front->next->next->pageNumber);
    printf("%d ", q->front->next->next->next->pageNumber);
    return 0;
}

