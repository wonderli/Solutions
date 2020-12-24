import java.util.*;
class Solution {
    private class Pair{
        String s;
        int frequency;
        public Pair(String s, int frequency){
            this.s = s;
            this.frequency = frequency;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.frequency == b.frequency) ? b.s.compareTo(a.s) : a.frequency - b.frequency);
        
        for(String s : map.keySet()){
            Pair p = new Pair(s, map.get(s));
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(0, pq.poll().s);
        }
        return result;
    }
}
