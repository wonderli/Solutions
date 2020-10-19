/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Integer> known = new HashMap<>();
        Set<Integer> nonCel = new HashSet<>();
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              if(i != j && knows(i, j)){
                  nonCel.add(i);
                  known.put(j, known.getOrDefault(j, 0)+1);
              }     
          }
        }
        int count = 0;
        int ret = -1;
        for(int key : known.keySet()){
            if(known.get(key) == n - 1 && !nonCel.contains(key)){
                ret = key;
                count++;
            }
        }
        return count == 1 ? ret : -1;
    }
}
