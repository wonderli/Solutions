import java.util.*;
    
public class Test{
    public static ArrayList<ArrayList<Integer>> subSet(ArrayList<Integer> set, int n){
        ArrayList<ArrayList<Integer>> allSubSet;
        if(n == 1) {
            allSubSet = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < set.size(); i++){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(set.get(i));
                allSubSet.add(tmp);
                return allSubSet;
            }
        }
        allSubSet = new ArrayList<ArrayList<Integer>>(); 
        for(int i = 0; i < set.size(); i++) {
            Integer item = set.get(i);
            ArrayList<Integer> newSet = (ArrayList<Integer>)set.clone();
            newSet.remove(i);
            ArrayList<ArrayList<Integer>> newRetSet = subSet(newSet, n - 1);
            for(ArrayList<Integer> e : newRetSet){
                e.add(i);
                allSubSet.add(e);
            }
        }
        return allSubSet;

    }
    public static void main(String args[]) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        int size = 5;
        for(int i = 0; i < size; i++){
            set.add(new Integer(i));
        }
        ArrayList<ArrayList<Integer>> ret = subSet(set, 3);
        for(ArrayList<Integer> e : ret) {
            for(Integer i : e) {
                System.out.print(i.intValue() + " ");
            }
            System.out.println();
        }

    }
}
