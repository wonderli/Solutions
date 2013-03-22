#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

class Solution{
    public:
        vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
            vector<Interval> ret;
            int n = intervals.size();
            if(n < 1){
                ret.push_back(newInterval);
                return ret;
            }
            for(int i = 0; i < n; i++){
                if(intervals[i].end < newInterval.start){
                    ret.push_back(intervals[i]);
                } else if(newInterval.end < intervals[i].start){
                    ret.push_back(newInterval);
                    int j = i;
                    while(j < n){
                        ret.push_back(intervals[j]);
                        j++;
                    }
                    return ret;
                }else{
                    newInterval.start = min(intervals[i].start, newInterval.start);
                    newInterval.end = max(intervals[i].end, newInterval.end);
                }
            }
            ret.push_back(newInterval);
            return ret;
        }
};
int main(int argc, char* argv[]){
}
