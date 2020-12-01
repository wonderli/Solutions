class Solution2 {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;
        
        for(int house = 1; house < n; house++){
            int minColor = -1;
            int secondMinColor = -1;
            
            for(int color = 0; color < k; color++){
                int cost = costs[house-1][color];
                if(minColor == -1 || cost < costs[house-1][minColor]){
                    secondMinColor = minColor;
                    minColor = color;
                }else if(secondMinColor == -1 || cost < costs[house -1][secondMinColor]){
                    secondMinColor = color;
                }
            }
            for(int color = 0; color < k; color++){
                if(color == minColor){
                    costs[house][color] += costs[house-1][secondMinColor];
                }else{
                    costs[house][color] += costs[house-1][minColor];
                }
            }
        }
            int min = Integer.MAX_VALUE;
            for(int c : costs[n -1]){
                min = Math.min(min, c);
            }
            return min;
        
    }
}