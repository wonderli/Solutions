import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        TwoSum ts = new TwoSum();
        ts.add(3);
        ts.add(2);
        ts.add(1);
        //System.out.println(ts.find(2));
        //System.out.println(ts.find(3));
        System.out.println(ts.find(4));
        //System.out.println(ts.find(5));
        //System.out.println(ts.find(6));
    }
}


class TwoSum {

    List<Integer> list = new ArrayList<>();

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int i = 0;
        int j = list.size() - 1;
        Collections.sort(list);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        while(i<j){
            int curr = arr[i] + arr[j];
            if(curr > value){
                j--;
            }else if(curr < value){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}

