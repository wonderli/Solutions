import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class FileSharing {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, List<Integer>> fileOwnership = new HashMap<>();
    Map<Integer, List<Integer>> userOwnership = new HashMap<>();
    int chunks;
    int counter = 0;
    public FileSharing(int m) {
        chunks = m;
        for(int i = 1; i <=m; i++){
            fileOwnership.computeIfAbsent(i, (k ->new ArrayList<>()));
        }
    }
    
    public int join(List<Integer> ownedChunks) {
        int id = getId();
        join(id, ownedChunks);
        return id;
    }
    
    private void join(int id, List<Integer> ownedChunks){
        for(int c : ownedChunks){
            fileOwnership.computeIfAbsent(c, (k ->new ArrayList<>())).add(id);
        }
        userOwnership.computeIfAbsent(id, (k -> new ArrayList<>())).addAll(ownedChunks);
    }
    
    private int getId(){
        if(pq.isEmpty()){
            counter++;
            return counter;
        }
        int id = pq.poll();
        return id;
    }
        
    
    public void leave(int userID) {
        List<Integer> owned = userOwnership.get(userID);
        for(int chunk : owned){
            List<Integer> user = fileOwnership.get(chunk);
            user.remove(Integer.valueOf(userID));
        }
        userOwnership.remove(userID);
        pq.add(userID);
    }
    
    public List<Integer> request(int userID, int chunkID) {
        List<Integer> owners = fileOwnership.getOrDefault(chunkID, new ArrayList<>());
        
        Collections.sort(owners);
        if(owners.isEmpty() || owners.contains(userID)) return owners;
        List<Integer> copy = new ArrayList<>(owners);
        join(userID, Arrays.asList(chunkID));
        
        return copy;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
