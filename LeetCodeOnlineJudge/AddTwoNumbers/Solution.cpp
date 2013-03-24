#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
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
         ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
             if(l1 == NULL) return l2;
             if(l2 == NULL) return l1;
             int c = 0;
             ListNode *head = new ListNode(0);
             ListNode *p = head;
             while(l1||l2||c){
                 if(l1){
                     c = l1->val + c;
                     l1 = l1->next;
                 }
                 if(l2){
                     c = l2->val + c;
                     l2 = l2->next;
                 }
                 p->next = new ListNode(c%10);
                 p = p->next;
                 c = c/10;
             }
             return head->next;
         }


};
int main(int argc, char* argv[]){
}
