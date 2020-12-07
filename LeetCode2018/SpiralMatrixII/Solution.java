class Solution {
    public int[][] generateMatrix(int n) {
        int curr = 1;
        int[][] matrix = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        while(top <= down && left <= right){
            for(int i = left; i <= right; i++){
                matrix[top][i] = curr;
                curr++;
            }
            top++;
            for(int i = top; i <= down; i++){
                matrix[i][right] = curr;
                curr++;
            }
            right--;
            if(left < right){
                for(int j = right; j>=left; j--){
                    matrix[down][j] = curr;
                    curr++;
                }
                down--;
            }
            if(top < down){
                for(int i = down; i >= top; i--){
                    matrix[i][left] = curr;
                    curr++;
                }
                left++;
            }
        }
        return matrix;
    }
}