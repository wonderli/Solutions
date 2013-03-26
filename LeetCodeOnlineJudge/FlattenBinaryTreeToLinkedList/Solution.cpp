#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#define p(x) std::cout << #x << ": " << x << std::endl;
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution{
    public:
         void flatten(TreeNode *root) {
             root = helper(root);
         }
         TreeNode *helper(TreeNode *root){
             if(root == NULL) return NULL;
             TreeNode *left = root->left;
             TreeNode *right = root->right;
             TreeNode *leftTail = helper(root->left);
             if(leftTail == NULL) leftTail = root;
             TreeNode *rightTail = helper(root->right);
             if(rightTail == NULL) rightTail = leftTail;
             root->left = NULL;
             root->right = left;
             leftTail->right = right;
             return rightTail;
         }


};
int main(int argc, char* argv[]){
}
