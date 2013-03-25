#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
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
        ListNode *swapPairs(ListNode *head) {
            if(!head) return head;
            ListNode *first = head;
            ListNode *second = head->next;
            if(!second) return first;
            ListNode *next = second->next;
            second->next  = first;
            first->next = swapPairs(next);
            return second;
        }



};
int main(int argc, char* argv[]){
}
