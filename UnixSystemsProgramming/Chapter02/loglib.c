#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "log.h"
//data_t 1. time_t time 2. char *string
typedef struct list_struct {
    data_t item;
    struct list_struct *next;
} log_t;

static log_t *headptr = NULL;
static log_t *tailptr = NULL;

int addmsg(data_t data){
    log_t *newnode;
    int nodesize;
    nodesize = sizeof(log_t) + strlen(data.string) + 1;
    if((newnode = (log_t *)(malloc(nodesize))) == NULL)
        return -1;
    newnode->item.time = data.time;
    newnode->item.string = (char *)newnode + sizeof(log_t);
    strcpy(newnode->item.string, data.string);
    newnode->next = NULL;
    if(headptr == NULL)
        headptr = newnode;
    else tailptr->next = newnode;
    tailptr = newnode;
    return 0;
}

void clearlog(void){
    log_t *next = headptr;
    while(next != NULL){
        next = headptr->next;
        free(headptr);
        headptr = next;
    }
}

char *getlog(void){
    size_t len = 0;
    size_t msglen = 0;
    size_t offset = 0;
    log_t *p = headptr;
    while(p != NULL){
        len += strlen(p->item.string) + 1;
        p = p->next;
    }
    char *log = (char *) malloc(len);
    if(log == NULL){
        perror("can't allocate memory for log");
        return NULL;
    }
    p = headptr;
    offset = 0;
    while(p){
        msglen = strlen(p->item.string);
        memcpy(log + offset, p->item.string, msglen);
        offset += msglen;
        memcpy(log + offset, "\n", 1);
        offset++;
        p = p->next;
    }
    memcpy(log + offset - 1, "\0", 1);
    return log;
}

int savelog(char *filename){
    FILE *f;
    log_t *node;
    if(filename == NULL){
        return -1;
    }
    f = fopen(filename, "w");
    if(f == NULL){
        perror("Failed to open file");
        return -1;
    }
    node = headptr;
    while(node){
        char *time = ctime(&node->item.time);
        time[strlen(time) - 1] = 0;
        fprintf(f, "%s: %s\n", time, node->item.string);
        node = node->next;
    }
    if(fclose(f)){
        perror("close failed");
        return -1;
    }
    return 0;
}
void log_msg(char *msg){
    data_t data;
    time(&data.time);
    size_t msglen = strlen(msg);
    data.string = malloc(msglen + 1);
    memcpy(data.string, msg, msglen + 1);
    addmsg(data);
    free(data.string);
}
int main(int argc, char **argv){
    log_msg("hello world");
    log_msg("ls -alh");
    log_msg("bc");
    log_msg("wc -l");
    char *log = getlog();
    printf("LOG:\n%s\n", log);
    free(log);
    savelog("log.txt");
    clearlog();
    log = getlog();
    printf("LOG:\n%s\n", log);
}
