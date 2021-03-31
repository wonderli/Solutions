import java.util.*;
import java.io.*;
import java.util.regex.*;
public class SortedDirList{
    private String[] dirList;
    public SortedDirList(File dir){
        dirList = dir.list();
        Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
    }
    public String[] list(){
        return dirList;
    }
    public String[] list(String regex){
        Pattern p = Pattern.compile(regex);
        ArrayList<String> sList = new ArrayList<String>();
        int count = 0;
        for(String s : dirList){
            if(p.matcher(s).matches()){
                count++;
                sList.add(s);
            }
        }
        return sList.toArray(new String[count]);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : dirList){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String args[]){
        SortedDirList dirList = new SortedDirList(new File("."));
        System.out.println(dirList);
        for(String s : dirList.list()){
            System.out.println(s);
        }
        System.out.println();
        for(String s : dirList.list(".+\\.java"))
            System.out.println(s);
    }
}
