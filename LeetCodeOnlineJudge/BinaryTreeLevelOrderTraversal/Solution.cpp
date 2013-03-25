#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution{
    public:
        vector<vector<int> > levelOrder(TreeNode *root) {
            vector<vector<int> > ret;
            if(root == NULL) return ret;
            queue<TreeNode *> curr;
            queue<TreeNode *> next;
            vector<int> currLevel;
            curr.push(root);
            while(!curr.empty()){
                TreeNode *t = curr.front();
                curr.pop();
                currLevel.push_back(t->val);
                if(t->left) next.push(t->left);
                if(t->right) next.push(t->right);
                if(curr.empty()){
                    ret.push_back(currLevel);
                    swap(curr, next);
                    currLevel.clear();
                }
            }
            return ret;
        }


};
int main(int argc, char* argv[]){
}
