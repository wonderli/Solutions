//Given an array of strings, return all groups of strings that are anagrams. 
import java.util.*;
public class Solution{
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hash = new HashMap<String,ArrayList<String>>();
        for(String str : strs){
            String tmp = sortStr(str);
            if(hash.containsKey(tmp)){
                hash.get(tmp).add(str);
            }else{
                ArrayList<String> v = new ArrayList<String>();
                v.add(str);
                hash.put(tmp, v);
            }
        }
        Iterator it = hash.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pairs = (Map.Entry)it.next();
            ArrayList<String> valueTmp = (ArrayList<String>)pairs.getValue();
            if(valueTmp.size() >= 2){
                for(String e : valueTmp){
                    ret.add(e);
                }
            }
        }
        return ret;
    }
    public String sortStr(String str){
        char strArray[] = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);
    }
    public static void main(String args[]){
    }
}
