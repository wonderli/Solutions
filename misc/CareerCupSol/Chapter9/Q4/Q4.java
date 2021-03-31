//Return all subset from a set
import java.util.*;
public class Q4{
    public static ArrayList<Integer> createSet(){
        ArrayList<Integer> set = new ArrayList<Integer>();
        int size = 5;
        for(int i = 0; i < size; i++){
            set.add(i);
        }
        return set;
    }
    public static ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSet;
        if(set.size() == index) {
            allSubSet = new ArrayList<ArrayList<Integer>>();
            allSubSet.add(new ArrayList<Integer>());
            return allSubSet;
        } else {
            allSubSet = getSubSet(set, index + 1);
            ArrayList<ArrayList<Integer>> indexSubSet = new ArrayList<ArrayList<Integer>>();
            int item = set.get(index);
            for(ArrayList<Integer> subSet: allSubSet){
                ArrayList<Integer> newSubSet = new ArrayList<Integer>();
                newSubSet.addAll(subSet);
                newSubSet.add(item);
                indexSubSet.add(newSubSet);
            }
            allSubSet.addAll(indexSubSet);
        }
        return allSubSet;
    }
    public static void main(String args[]){
        ArrayList<Integer> set = createSet();
        System.out.println(getSubSet(set, 0));

    }
}
