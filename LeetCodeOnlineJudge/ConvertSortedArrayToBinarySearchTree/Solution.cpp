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
        TreeNode *helper(vector<int> &num, int l, int r){
            if(l > r) return NULL;
            int mid = (l + r)/2;
            TreeNode *root = new TreeNode(num[mid]);
            root->left = helper(num, l, mid-1);
            root->right = helper(num, mid + 1, r);
            return root;

        }

        TreeNode *sortedArrayToBST(vector<int> &num) {
            return helper(num, 0, num.size()-1);
        }
};
int main(int argc, char* argv[]){
}
