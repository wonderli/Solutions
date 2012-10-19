import java.util.*;
public class Q452{
    public static void printCandidates(int candidates[], int index[], int n){
        for(int i = 1; i <= n; i++){
            if(i != n){
                System.out.print(candidates[index[i]] + "+");
            } else {
                System.out.print(candidates[index[i]] + " ");
            }
        }
        System.out.println();
    }
    public static void getCombination(int candidates[], int target, int sum, int index[], int n){
        if(sum > target) return;
        if(sum == target) {
            printCandidates(candidates, index, n);
            return;
        }
        for(int i = index[n] + 1; i < candidates.length; i++) {
            index[n+1] = i;
            getCombination(candidates, target, sum + candidates[i], index, n+1);
        }
    }
    public static void main(String args[]){
        int array[] = {1, 2, 3, 4, 5, 6};
        int target = 8;
        int index[] = new int[1000];
        index[0] = 0;
        int sum = 0;
        getCombination(array, target, sum, index, 0);
    }
}
