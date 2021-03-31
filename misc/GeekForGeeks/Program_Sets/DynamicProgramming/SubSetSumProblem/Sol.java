//GeekForGeeks
//Dynamic Programming Set 25
//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
public class Sol{
    public static boolean isSubset(int array[], int sum, int index){
        if(sum == 0) return true;
        if(index == 0 && sum != 0) return false;
        if(array[index - 1] > sum) return isSubset(array, sum, index-1);
        return isSubset(array, sum, index-1)||isSubset(array, sum - array[index-1], index-1);
    }
    public static boolean isSubset2(int array[], int sum, int index){
        boolean mark[][] = new boolean[sum+1][index+1];
        for(int i = 0; i <=index; i++){
            mark[0][i] = true;
        }
        for(int i = 0; i <= sum; i++){
            mark[i][0] = false;
        }
        for(int i = 1; i <= sum; i++){
            for(int j = 1; j <= index; j++){
                mark[i][j] = mark[i][j-1];
                if(array[j-1] <= i){
                    mark[i][j] = mark[i][j-1] || mark[i - array[j-1]][j-1];
                }
            }
        }
        return mark[sum][index];
    }
    public static void main(String[] args){
        int array[] = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubset(array, 9, array.length-1));
        System.out.println(isSubset2(array, 9, array.length-1));
    }
}
