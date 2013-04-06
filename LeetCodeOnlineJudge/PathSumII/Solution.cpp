#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#define p(x) std::cout << #x << ": " << x << std::endl;
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution{
    public:
         vector<vector<int> > pathSum(TreeNode *root, int sum) {
             vector< vector<int> > ret;
             if(root == NULL) return ret;
             vector<int> curr;
             helper(root, sum, curr, ret);
             return ret;
         }
         void helper(TreeNode *root, int sum, vector<int> &curr, vector< vector<int> > &ret){
             if(root == NULL) return;
             if(root->val == sum && root->left == NULL && root->right == NULL){
                 curr.push_back(root->val);
                 ret.push_back(curr);
                 return;
             }
             if(root->val != sum && root->left == NULL && root->right == NULL){
                 return;
             }
             curr.push_back(root->val);
             vector<int> left = curr;
             vector<int> right = curr;
             helper(root->left, sum - root->val, left, ret);
             helper(root->right, sum - root->val, right, ret);

         }


};
int main(int argc, char* argv[]){
}
