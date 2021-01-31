import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class Leaderboard {

    private Map<Integer, Integer> dict;
    private TreeMap<Integer, Integer> sortedScores;
    public Leaderboard() {
        dict = new HashMap<>();
        sortedScores = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if(!dict.containsKey(playerId)){
            dict.put(playerId, score);
            sortedScores.put(score, sortedScores.getOrDefault(score, 0) + 1)
;        }else{
            int oldScore = dict.get(playerId);
            int oldCount = sortedScores.get(oldScore);
            if(oldCount == 1){
                sortedScores.remove(oldScore);
            }else{
                sortedScores.put(oldScore, oldCount - 1);
            }
            
            int newScore = oldScore + score;
            dict.put(playerId, newScore);
            sortedScores.put(newScore, sortedScores.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int count = 0;
        int sum = 0;
        for(int key : sortedScores.keySet()){
            int times = sortedScores.get(key);
            for(int i = 0; i < times; i++){
                sum += key;
                count++;
                if(count == K){
                    break;
                }
            }
            if(count == K){
                break;
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int oldScore = dict.get(playerId);
        sortedScores.put(oldScore, sortedScores.get(oldScore) - 1);
        if(sortedScores.get(oldScore) == 0){
            sortedScores.remove(oldScore);
        }
        dict.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
