//find all paths for the current value in a Binary Tree
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXBUFF 1024
typedef struct Node {
    int value;
    struct Node *left;
    struct Node *right;
} Node;
Node *newNode(int value){
    Node *n = (Node *)malloc(sizeof(Node));
    n->value = value;
    n->left = NULL;
    n->right = NULL;
    return n;
}
void print_path(Node *node, char *s){
    char *tmp = s;
    printf("\n");
    printf("%d->", node->value);
    while(*tmp != '\0'){
        switch(*tmp){
            case 'l':
            {
                node = node->left;
                printf("%d->", node->value);
                break;
            }
            case 'r':
            {
                node = node->right;
                printf("%d->", node->value);
                break;
            }
        }
        tmp++;
    }
    printf("\n");

}


int f(int value, Node *node, char *s, Node *head){
    if(node == NULL){
        return 0;
    }

    if(node->value == value){
        //printf("value is equal to root\n");
        print_path(head, s);
        return 0;
    }
    if(value == 0){
        print_path(head, s);
        return 0;
    }
    char *left_s = (char *)malloc(MAXBUFF);
    strcpy(left_s, s);
    strcat(left_s,"l");
    f(value - node->value, node->left, left_s, head);
    char *right_s = (char *)malloc(MAXBUFF);
    strcpy(right_s, s);
    strcat(right_s,"r");
    f(value - node->value, node->right, right_s, head);
}

//       10
//      / \
//     5 12
//    / \
//   4   7




int main(){
    Node *root = newNode(10);
    root->left = newNode(5);
    root->right = newNode(12);
    root->left->left = newNode(4);
    root->left->right= newNode(7);
    char *s = (char *)malloc(MAXBUFF);
    //strcpy(s, "ll");
    //print_path(root, s);
    f(10,root,s,root);

    return 0;
}
