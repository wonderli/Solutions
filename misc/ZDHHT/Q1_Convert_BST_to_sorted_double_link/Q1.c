#include <stdio.h>
#define ISLEFT 0
#define ISRIGHT 1
typedef struct BSTNode{
    int value;
    struct BSTNode* left;
    struct BSTNode* right;
} BSTNode;

BSTNode *ConvertNode(BSTNode *p_node, int isRight){
    if(!p_node) return NULL;
    BSTNode *p_left = NULL;
    BSTNode *p_right = NULL;
    if(p_node->left) p_left = ConvertNode(p_node->left, ISLEFT);
    if(p_left) {
        p_left->right = p_node;
        p_node->left = p_left;
    }
    if(p_node->right) p_right = ConvertNode(p_node->right, ISRIGHT);
    if(p_right) {
        p_right->left = p_node;
        p_node->right = p_right;
    }
    BSTNode *p_tmp = p_node;
    if(isRight) {
        while(p_tmp->left) {
            p_tmp = p_tmp->left;
        }
    } else {
        while(p_tmp->right) {
            p_tmp = p_tmp->right;
        }
    }
    return p_tmp;
}
BSTNode *Convert(BSTNode *p_node) {
    return ConvertNode(p_node, ISRIGHT);
}

int main(){
    return 0;
}
