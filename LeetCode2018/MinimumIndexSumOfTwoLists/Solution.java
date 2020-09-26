import java.util.*;
public class Solution{
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] l1 = list1.length > list2.length ? list1 : list2;
        String[] l2 = list1.length > list2.length ? list2 : list1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < l1.length; i++){
            map.put(l1[i], i);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < l2.length; i++){
            if(map.containsKey(l2[i])){
                Pair p = new Pair(l2[i], i + map.get(l2[i]));
                pq.add(p);
            }
        }
        List<String> ret = new ArrayList<>();
        Pair first = pq.poll();
        int firstSum = first.sum;
        ret.add(first.s);
        while(!pq.isEmpty() && pq.peek().sum == firstSum){
            Pair p = pq.poll();
            ret.add(p.s);
        }
        return ret.toArray(new String[0]);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Pair implements Comparable<Pair>{
    String s;
    int sum;
    public Pair(String s, int sum){
        this.s = s;
        this.sum = sum;
    }
    @Override
    public int compareTo(Pair p){
        return this.sum - p.sum;
    }
}

