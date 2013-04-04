#include <stdio.h>
#include <stdlib.h>
typedef struct TreeNode{
    struct TreeNode *left;
    struct TreeNode *right;
    unsigned long int val;
} TreeNode;
TreeNode *create(TreeNode *root, unsigned long int val, unsigned long int parent){
    if(root == NULL){
        root = (TreeNode *)malloc(sizeof(TreeNode));
        root->left = NULL;
        root->right = NULL;
        root->val = val;
        printf("%ld\n", parent);
        return root;
    }
    if(root->val < val){
        root->right = create(root->right, val, root->val);
    }else if(root->val > val){
        root->left = create(root->left, val, root->val);
    }
    return root;
}
int main(){
    int N = 0;
    int i = 0;
    TreeNode *root = NULL;
    while(scanf("%d", &N) != EOF){
        root = NULL;
        unsigned long int a[N];
        for(i = 0; i < N; i++){
            scanf("%ld", &a[i]);
        }
        for(i = 0; i < N; i++){
            root = create(root, a[i], -1);
        }
    }
}
