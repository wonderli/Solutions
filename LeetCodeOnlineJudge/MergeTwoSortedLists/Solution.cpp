#include <iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution{
    public:
        ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
            if(l1 == NULL) return l2;
            if(l2 == NULL) return l1;
            ListNode *head = l1->val < l2->val ? l1 : l2;
            head->next = l1->val < l2->val ? mergeTwoLists(l1->next , l2) : mergeTwoLists(l1, l2->next);
            return head;
        }

};
int main(int argc, char* argv[]){
}
