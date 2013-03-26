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
         vector<int> inorderTraversal(TreeNode *root) {
             vector<int> ret;
             if(root == NULL){
                 return ret;
             }
             stack<TreeNode *> s;
             TreeNode* curr = root;
             while(!s.empty() || curr != NULL){
                 if(curr){
                     s.push(curr);
                     curr = curr->left;
                 }else{
                    curr = s.top();
                    s.pop();
                    ret.push_back(curr->val);
                    curr = curr->right;
                 }
             }
             return ret;
         }


};
int main(int argc, char* argv[]){
}
