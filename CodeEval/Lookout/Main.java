import java.util.*;
import java.io.*;
public class Main{
    public static void solve(String input, ArrayList<String> ret){
        StringTokenizer st = new StringTokenizer(input, ";,");
        String text = null;
        if(st.hasMoreTokens()){
            text = st.nextToken();
        }
        if(text == null) return;
        int len = text.length();
        ArrayList<String> replaceList = new ArrayList<String>();
        while(st.hasMoreTokens()){
            String replace = st.nextToken();
            replaceList.add(replace);
        }
        //System.out.println(replaceList);
        int size = replaceList.size();
        boolean  mark[] = new boolean[len];
        for(int i = 0; i < size; i+=2){
            String a = replaceList.get(i);
            String b = replaceList.get(i+1);
            //System.out.println(Arrays.toString(mark));
            int index = strstr(text, a, mark);
            if(index == -1 ) continue;
            text = text.substring(0, index) + b + text.substring(index + a.length());
            boolean newmark[] = new boolean[text.length()];
            markLast(mark, newmark, index, index + b.length(), a.length());
            mark = newmark;
        }
        //System.out.println(text);
        ret.add(text);
    }
    public static void markLast(boolean mark[], boolean newmark[], int start, int end, int aLen){
        for(int i = 0; i < start; i++){
            newmark[i] = mark[i]; 
        }
        for(int i = start; i < end; i++){
            newmark[i] = true;
        }
        for(int i = end, j = start + aLen; i < newmark.length && j < mark.length; i++, j++){
            newmark[i] = mark[j];
        }
    }
    public static int strstr(String text, String a, boolean mark[]){
        int len = text.length();
        int aLen = a.length();
        int i = 0;
        int begin = 0;
        int j = 0;
        while(i < len && j < aLen){
            if((text.charAt(i) == a.charAt(j)) && mark[i] == false){
                i++;
                j++;
            }else{
                begin++;
                i = begin;
                j = 0;
            }
        }
        if(j == aLen){
            return i - aLen;
        }
        return -1;
    }
    public static void printResult(ArrayList<String> ret){
        for(String str : ret){
            System.out.println(str);
        }
    }
    public static void main(String args[]){
        //System.out.println(pathName);
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> ret = new ArrayList<String>();
            while((line = in.readLine()) != null){
                solve(line, ret);
            }
            in.close();
            printResult(ret);
        }catch(IOException e){
            System.out.println("File Read Error: " + e.getMessage());
        }

    }
}
