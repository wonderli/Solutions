//Given an array of strings, remove duplicates according to these rules:
//
//    Two strings are identical when words matches (case insensitive) and order doesn't matter, so "apple Orange" == "APPLe oRange" == "ORANGE apple".
//        If multiple identical strings exist, prefer the one that occurs at the last location, so if input is ["apple Orange", "ORANGE apple", "APPLe oRange", "HI There", "THERE hI"], only "APPLe oRange" and "THERE hI" will be returned.
//            The relative order of the original array cannot be changed, so we cannot have result as ["THERE hI", "APPLe oRange"].
//
//            For example, given input:
//
//            ["apple Orange", "ORANGE apple", "APPLe oRange", "HI There", "THERE hI"]
//
//            Return
//
//            ["APPLe oRange", "THERE hI"]
//
//
import java.util.*;
public class Solution{
    public String[] removeDuplicates(String[] input){
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> ret = new ArrayList<String>();
        for(int i = input.length - 1; i >= 0; i--){
            String currString = input[i].toLowerCase();
            char currStringArray[] = currString.toCharArray();
            Arrays.sort(currStringArray);
            String sortedString = Arrays.toString(currStringArray);
            if(!set.contains(sortedString)){
                ret.add(input[i]);
                set.add(sortedString);
            }
        }
        Collections.reverse(ret);
        return ret.toArray(new String[ret.size()]);
    }
    public static void main(String args[]){
        String[] input = {"apple Orange", "ORANGE apple", "APPLe oRange", "HI There", "THERE hI"};
        Solution s = new Solution();
        String[] result = s.removeDuplicates(input);
        for(String e : result){
            System.out.println(e);
        }
    }
}
