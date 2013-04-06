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
        bool hasPathSum(TreeNode *root, int sum) {
            if(root == NULL) return false;
            if(root->val == sum && root->left == NULL && root->right == NULL) return true;
            return hasPathSum(root->left, sum - root->val)||hasPathSum(root->right, sum - root->val);
        }


};
int main(int argc, char* argv[]){
}
