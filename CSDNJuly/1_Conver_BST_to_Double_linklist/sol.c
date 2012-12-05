#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
typedef struct node{
    struct node *left;
    struct node *right;
    int val;
} Node;
Node *createNewNode(int val){
    Node *n = (Node *)malloc(sizeof(Node));
    n->left = NULL;
    n->right = NULL;
    n->val = val;
    return n;
}
Node *buildBST(){
    Node *root = createNewNode(10);
    root->left = createNewNode(6);
    root->right = createNewNode(14);
    root->left->left = createNewNode(4);
    root->left->right = createNewNode(8);
    root->right->left = createNewNode(12);
    root->right->right = createNewNode(16);
    return root;
}
/*          10
 *      /       \
 *     6        14
 *  4     8   12   16
 *          9
 */
Node *createDoubleLinklist(Node *root, int isRight){
    if(root == NULL) return NULL;
    Node *left = NULL;
    Node *right = NULL;
    if(root->left){
        left = createDoubleLinklist(root->left, FALSE);
    }
    if(left){
        left->right = root;
        root->left = left;
    }
    if(root->right){
        right = createDoubleLinklist(root->right, TRUE);
    }
    if(right){
        root->right = right;
        right->left = root;
    }
    Node *tmp = root;
    if(isRight == TRUE){
        while(tmp->left){
            tmp = tmp->left;
        }
    }else{
        while(tmp->right){
            tmp = tmp->right;
        }
    }
    return tmp;

}
void printLinkList(Node *root){
    while(root->right != NULL){
        printf("%d -> ", root->val);
        root = root->right;
    }
    printf("%d -> ", root->val);
    printf("\n");
    while(root->left != NULL){
        printf("%d -> ", root->val);
        root = root->left;
    }
    printf("%d -> ", root->val);
    printf("\n");
}
int main(){
    Node *root = buildBST();
    Node *n = createDoubleLinklist(root, TRUE);
    printLinkList(n);
    return 0;
}
