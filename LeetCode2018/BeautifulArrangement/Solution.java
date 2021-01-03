class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if(N == 0) return count;
        helper(1, N, new boolean[N+1]);
        return count;
    }
    public void helper(int pos, int N, boolean[] visited){
        if(pos > N) {
            count++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i] && ((pos % i == 0) || (i %pos == 0))){
                visited[i] = true;
                helper(pos + 1, N, visited);
                visited[i] = false;
            }
        }

    }
}