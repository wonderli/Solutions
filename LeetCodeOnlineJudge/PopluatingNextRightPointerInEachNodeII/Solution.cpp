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
            solve(root, NULL);
        }
        void solve(TreeLinkNode *curr, TreeLinkNode *parent){
            if(curr == NULL) return;
            if(parent != NULL){
                if(curr == parent->left && parent->right != NULL){
                    curr->next = parent->right;
                }else{
                    TreeLinkNode *parentNext = parent->next;
                    curr->next = NULL;
                    while(parentNext != NULL){
                        if(parentNext->left != NULL){
                            curr->next = parentNext->left;
                            break;
                        }else if(parentNext->right != NULL){
                            curr->next = parentNext->right;
                            break;
                        }
                        parentNext = parentNext->next;
                    }
                }
            }else{
                curr->next = NULL;
            }
            //need first right then left;
            solve(curr->right, curr);
            solve(curr->left, curr);
        }

};
int main(int argc, char* argv[]){
}
