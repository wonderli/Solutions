import java.util.*;
public class Q70{
    public static HashSet<ArrayList<Integer>> findTriplet(int array[]){
        Arrays.sort(array);
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        int n = array.length;
        for(int i = 0; i < n; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum2 = array[i] + array[j];
                if(sum2 + array[k] < 0) {
                    j++;
                }else if(sum2 + array[k] > 0) {
                    k--;
                }else{
                    ArrayList<Integer> v = new ArrayList<Integer>();
                    v.add(array[i]);
                    v.add(array[j]);
                    v.add(array[k]);
                    ret.add(v);
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }

    public static void main(String args[]){
        int array[] = {-1, 0, 1, 2, -1, -4};
        HashSet<ArrayList<Integer>> ret = findTriplet(array);
        for(ArrayList<Integer> e : ret){
            System.out.println(e.toString());
        }
    }
}
