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
        ListNode *partition(ListNode *head, int x) {
            if(head == NULL) return head;
            ListNode *dummy1 = new ListNode(0);
            ListNode *dummy2 = new ListNode(0);
            ListNode *h1 = dummy1;
            ListNode *h2 = dummy2;
            ListNode *p = head;
            while(p != NULL){
                if(p->val < x){
                    dummy1->next = new ListNode(p->val);
                    dummy1 = dummy1->next;
                }else{
                    dummy2->next = new ListNode(p->val);
                    dummy2 = dummy2->next;
                }
                p = p->next;
            }
            dummy1->next = h2->next;
            return h1->next;

        }


};
int main(int argc, char* argv[]){
}
