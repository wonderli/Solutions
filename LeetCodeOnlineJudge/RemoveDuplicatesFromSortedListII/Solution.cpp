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
             if(head == NULL) return NULL;
             ListNode *dummy = new ListNode(0);
             dummy->next = head;
             ListNode *prev = dummy;
             ListNode *curr = head;
             while(curr != NULL){
                 bool dup = false;
                 while(curr->next != NULL && curr->next->val == curr->val){
                     dup = true;
                     curr = curr->next;
                 }
                 if(dup){
                     prev->next = curr->next;
                     curr = curr->next;
                 }else{
                     prev = curr;
                     curr = curr->next;
                 }
             }
             return dummy->next;
         }


};
int main(int argc, char* argv[]){
}
