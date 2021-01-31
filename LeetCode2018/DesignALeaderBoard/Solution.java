import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Leaderboard {

    private Map<Integer, Integer> playerIdScoreMap;
    public Leaderboard() {
        playerIdScoreMap = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        playerIdScoreMap.put(playerId, playerIdScoreMap.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int sum = 0;
        for(int id : playerIdScoreMap.keySet()){
            int score = playerIdScoreMap.get(id);
            sum += score;
            pq.add(new int[]{id, score});
            if(pq.size() > K){
                int[] p = pq.poll();
                sum -= p[1];
            }
        }
        return sum;
        
    }
    
    public void reset(int playerId) {
        playerIdScoreMap.put(playerId, 0);
        
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */