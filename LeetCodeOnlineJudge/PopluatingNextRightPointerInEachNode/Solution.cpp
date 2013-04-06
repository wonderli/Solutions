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
struct TreeLinkNode {
    int val;
    TreeLinkNode *left;
    TreeLinkNode *right;
    TreeLinkNode *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution{
    public:
        void connect(TreeLinkNode *root) {
            if(root == NULL) return;
            TreeLinkNode *parent = NULL;
            helper(root, parent);
        }
        void helper(TreeLinkNode *&root, TreeLinkNode *&parent){
            if(root == NULL) return;
            if(parent != NULL){
                if(root == parent->left){
                    root->next = parent->right;
                }else if(root == parent->right){
                    root->next = (parent->next == NULL) ? NULL : parent->next->left;
                }
            }else{
                root->next = NULL;
            }
            helper(root->left, root);
            helper(root->right, root);
        }


};
int main(int argc, char* argv[]){
}
