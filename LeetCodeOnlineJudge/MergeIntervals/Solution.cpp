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
        static bool cmp(Interval a, Interval b){
            return a.start < b.start;
        }
        vector<Interval> merge(vector<Interval> &intervals) {
            int n = intervals.size();
            if(n < 2) return intervals;
            sort(intervals.begin(), intervals.end(), cmp);
            int start = intervals[0].start;
            int end = intervals[0].end;
            vector<Interval> ret;
            for(int i = 0; i < n; i++){
                if(end >= intervals[i].start){
                    end = max(end, intervals[i].end);
                }else{
                    Interval t(start, end);
                    ret.push_back(t);
                    start = intervals[i].start;
                    end = intervals[i].end;
                }
            }
            //for(int i = 1; i < n; i++){
            //    if(end < intervals[i].start){
            //        Interval t(start, end);
            //        ret.push_back(t);
            //        int j = i;
            //        while(j < n){
            //            ret.push_back(intervals[j]);
            //            j++;
            //        }
            //        return ret;
            //    }else if(start > intervals[i].end){
            //        ret.push_back(intervals[i]);
            //    }else{
            //        start = min(intervals[i].start, start);
            //        end = max(intervals[i].end, end);
            //    }
            //}
            Interval t(start, end);
            ret.push_back(t);
            return ret;
        }



};
int main(int argc, char* argv[]){
}
