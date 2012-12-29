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
    public static void main(String[] args){
        int array[] = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubset(array, 9, array.length-1));
    }
}
