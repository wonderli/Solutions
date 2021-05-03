import java.util.*;
class Solution{
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b)->(a[1] - b[1]));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b - a));
		int start = 0;
		for(int[] e : courses){
			if(start + e[0] <= e[1]){
				pq.add(e[0]);
				start += e[0];
			}else if(!pq.isEmpty() && pq.peek() > e[0]){
				start += e[0] - pq.poll();
				pq.add(e[0]);
			}
		}
		return pq.size();
	}
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
