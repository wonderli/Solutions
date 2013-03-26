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
        TreeNode *sortedListToBST(ListNode *head) {
            ListNode *p = head;
            int n = 0;
            while(p != NULL){
                p = p->next;
                n++;
            }
            return helper(head, 0, n-1);
        }
        TreeNode *helper(ListNode* &head, int l, int r){
            if(l > r) return NULL;
            int mid = l + (r - l)/2;
            TreeNode *left = helper(head, l, mid - 1);
            TreeNode *root = new TreeNode(head->val);
            root->left = left;
            head = head->next;
            TreeNode *right = helper(head, mid + 1, r);
            root->right = right;
            return root;

        }


};
int main(int argc, char* argv[]){
}
