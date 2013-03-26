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
class Solution{
    public:
         ListNode *deleteDuplicates(ListNode *head) {
             if(head == NULL) return head;
             ListNode *dummy = new ListNode(0);
             dummy->next = head;
             ListNode *p1 = dummy->next;
             int last = p1->val;
             ListNode *p2 = dummy->next;
             while(p1 != NULL){
                 if(p1->val == last){
                     p1 = p1->next;
                 }else{
                     p2 = p2->next;
                     p2->val = p1->val;
                     p1 = p1->next;
                     last = p2->val;
                 }
             }
             p2->next = NULL;
             return dummy->next;

         }


};
int main(int argc, char* argv[]){
}
