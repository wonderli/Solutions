//Travese Tree By Order, recursive implementation
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
typedef struct node{
    struct node *left;
    struct node *right;
    int data;
} Node;
Node *newNode(int data){
    Node *new = (Node *)malloc(sizeof(Node));
    new->data = data;
    new->left = NULL;
    new->right = NULL;
    return new;
}
int max(int a, int b){
    if(a > b) return a;
    else return b;
}
void print_given_level_node(int level, Node *n){
    if(n == NULL) return ;
    if(level == 1) {
        printf("Data: %d \n", n->data);
        return;
    }
    else if(level > 1){
        print_given_level_node(level-1, n->left);
        print_given_level_node(level-1, n->right);
    }
}
int height(Node *n){
    if(n == NULL) return 0;
    else{
        return max(height(n->left), height(n->right)) + 1;
    }
}
void print_nodes(Node *n){
    int h = height(n);
    int i = 0;
    for(i = 1; i <= h; i++ ){
        print_given_level_node(i, n);
    }
}
int main() {
    Node *root = newNode(1);
    root->left        = newNode(2);
    root->right       = newNode(3);
    root->left->left  = newNode(4);
    root->left->right = newNode(5); 
    printf("Level order traverse\n");
    print_nodes(root);
    return 0;
}
