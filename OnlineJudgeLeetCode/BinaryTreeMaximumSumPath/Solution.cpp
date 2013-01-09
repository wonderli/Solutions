//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
#include <iostream>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
    public:
     int maxPathSum(TreeNode *root) {
         int currSum = 0;
         int maxSum = INT_MIN;
         maxPath(root, currSum, maxSum);
         return maxSum;
     }
     void maxPath(TreeNode *root, int &currSum, int &maxSum){
         if(!root) {
             currSum = 0;
             return;
         }
         int leftSum = 0;
         int rightSum = 0;
         maxPath(root->left, leftSum, maxSum);
         maxPath(root->right, rightSum, maxSum);
         currSum = max(root->val, max(root->val + leftSum, root->val + rightSum));
         maxSum = max(maxSum, max(currSum, root->val + leftSum + rightSum));
     }

};
int main(){
    return 0;
}
