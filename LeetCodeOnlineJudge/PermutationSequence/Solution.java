//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"

//Given n and k, return the kth permutation sequence.
public class Solution{
    public String getPermutation(int n, int k) {
        if(n == 1) return new String("1");
        int fac = factorial(n - 1);
        StringBuilder sb = new StringBuilder();
        boolean used[] = new boolean[n];
        for(int i = 0; i < n; i++){
            used[i] = false;
        }
        k--;
        for(int i = 0; i < n; i++){
            int d = k / fac + 1;
            int j = 0;
            for(; j < n; j++){
                if(used[j] == false){
                    d--;
                }
                if(d == 0){
                    break;
                }
            }
            used[j] = true;
            sb.append(j + 1);
            if(i < n - 1){
                k = k % fac;
                fac = fac / (n - 1 - i);
            }
        }
        return sb.toString();
    }
    public int factorial(int num){
        if(num == 0) return 1;
        return num * factorial(num - 1);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //System.out.println(sol.factorial(5));
    }
}
