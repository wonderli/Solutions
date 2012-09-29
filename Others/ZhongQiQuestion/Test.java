import java.util.*;
    
public class Test{
    public static ArrayList<ArrayList<Integer>> subSet(ArrayList<Integer> set, int n){
        ArrayList<ArrayList<Integer>> allSubSet;
        if(n == 1) {
            allSubSet = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(set.get(0));
            allSubSet.add(tmp);
            return allSubSet;
        }
        allSubSet = new ArrayList<ArrayList<Integer>>(); 
        for(int i = 0; i < set.size(); i++) {
            Integer item = set.get(i);
            ArrayList<Integer> newSet = cloneSet(set);
            newSet.remove(i);
            ArrayList<ArrayList<Integer>> newRetSet = subSet(newSet, n - 1);
            for(ArrayList<Integer> e : newRetSet){
                e.add(item.intValue());
                allSubSet.add(e);
            }
        }
        return allSubSet;

    }
    public static ArrayList<Integer> cloneSet(ArrayList<Integer> set) {
        ArrayList<Integer> newSet = new ArrayList<Integer>();
        for(Integer e : set) {
            newSet.add(e);
        }
        return newSet;
    }

    public static void printRes(ArrayList<ArrayList<Integer>> set){
        System.out.println();
        for(ArrayList<Integer> e : set) {
            for(Integer i : e) {
                System.out.print(i.intValue() + " ");
            }
            System.out.println();
        }
    }
//    public static void printRes(ArrayList<ArrayList<Integer>> set){
//        System.out.println();
//        for(ArrayList<Integer> e : set) {
//            for(Integer i : e) {
//                System.out.print(i.intValue() + " ");
//            }
//            System.out.println();
//        }
//    }

    public static HashSet<HashSet<Integer>> clean(ArrayList<ArrayList<Integer>> list){
        HashSet<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
        for(ArrayList<Integer> le : list){
            HashSet<Integer> hashCell = new HashSet<Integer>();
            for(Integer e : le) {
                hashCell.add(e);
            }
            set.add(hashCell);
        }
        return set;
    }
    public static void main(String args[]) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        int size = 5;
        for(int i = 0; i < size; i++){
            set.add(new Integer(i));
        }
        ArrayList<ArrayList<Integer>> ret = subSet(set, 3);
        //printRes(ret);
        HashSet<HashSet<Integer>> hashSet = new HashSet<HashSet<Integer>>();
        hashSet = clean(ret);
        System.out.println(hashSet);
    }
}
