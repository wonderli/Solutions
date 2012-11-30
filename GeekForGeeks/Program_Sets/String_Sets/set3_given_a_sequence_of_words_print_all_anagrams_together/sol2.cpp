#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cctype>
#define NUM_OF_CHARS 26
typedef struct indexNode {
    int index;
    struct indexNode *next;
} IndexNode;
typedef struct trieNode {
    bool isEnd;
    struct trieNode *child[NUM_OF_CHARS];
    struct indexNode *head;
} TrieNode;
TrieNode *newTrieNode(){
    TrieNode *tmp = new TrieNode;
    tmp->isEnd = false;
    tmp->head = NULL;
    for(int i = 0; i < NUM_OF_CHARS; i++){
        tmp->child[i] = NULL;
    }
    return tmp;
}
int compare(const void *a, const void *b){
    return *(char *)a - *(char *)b;
}
IndexNode * newIndexNode(int index){
    IndexNode *tmp = new IndexNode;
    tmp->index = index;
    tmp->next = NULL;
    return tmp;
}
void insert(TrieNode **root, char *word, int index){
    if(*root == NULL) *root = newTrieNode();
    if(*word != '\0'){
        insert(&((*root)->child[tolower(*word) - 'a']), word+1, index);
    }else {
        if((*root)->isEnd){
            IndexNode *pCrawl = (*root)->head;
            while(pCrawl->next){
                pCrawl = pCrawl->next;
            }
            pCrawl->next = newIndexNode(index);
        }else{
            (*root)->isEnd = true;
            (*root)->head = newIndexNode(index);
        }
    }
}
void printAnagramsUtil(TrieNode *root, char *wordArray[]){
    if(root == NULL) return ;
    if(root->isEnd){
        IndexNode *pCrawl = root->head;
        while(pCrawl != NULL){
            printf("%s \n", wordArray[pCrawl->index]);
            pCrawl = pCrawl->next;
        }
    }
    for(int i = 0; i < NUM_OF_CHARS; i++){
        printAnagramsUtil(root->child[i], wordArray);
    }
}
void printAnagramsTogether(char *wordArray[], int size){
    TrieNode *root = NULL;
    for(int i = 0; i < size; i++){
        int len = strlen(wordArray[i]);
        char *buffer = new char[len+1];
        strcpy(buffer, wordArray[i]);
        qsort((void *)buffer, strlen(buffer), sizeof(char), compare);
        insert(&root, buffer, i);
    }
    printAnagramsUtil(root, wordArray);
}
int main(){
    char *wordArray[] = {"cat", "dog", "tac", "god", "act", "gdo"};
    int size = sizeof(wordArray)/sizeof(wordArray[0]);
    printAnagramsTogether(wordArray, size);
    return 0;
}
