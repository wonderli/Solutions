#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
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
        bool isValidBST(TreeNode *root) {
            return checkBST(root, INT_MIN, INT_MAX);
        }
        bool checkBST(TreeNode *root, int min, int max){
            if(root == NULL) return true;
            if(root->val > min && root->val < max){
                return checkBST(root->left, min, root->val) && checkBST(root->right, root->val, max);
            }
            return false;
        }



};
int main(int argc, char* argv[]){
}
