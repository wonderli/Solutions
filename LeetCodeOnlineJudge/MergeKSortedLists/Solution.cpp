#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
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

class MyCmp{
    public:
        bool operator() (const ListNode *lhs, const ListNode *rhs) {
            return (lhs->val > rhs->val);
        }
};

class Solution{
    public:
        ListNode *mergeKLists(vector<ListNode *> &lists) {
            priority_queue<ListNode *, vector<ListNode *>, MyCmp > queue;
            int n = lists.size();
            ListNode *ret = NULL;
            for(int i = 0; i < n; i++){
                if(lists[i] != NULL){
                    queue.push(lists[i]);
                }
            }
            if(queue.empty()) return NULL;
            ret = queue.top();
            queue.pop();
            ListNode *curr = ret;
            if(curr->next != NULL) queue.push(curr->next);
            while(!queue.empty()){
                curr->next = queue.top();
                queue.pop();
                curr = curr->next;
                if(curr->next != NULL){
                    queue.push(curr->next);
                }
            }
            return ret;


        }


};
int main(int argc, char* argv[]){
}
