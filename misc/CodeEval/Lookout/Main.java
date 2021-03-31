import java.util.*;
import java.io.*;
public class Main{
    public void solve(String input, ArrayList<String> ret){
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
        if(size%2 != 0){
            ret.add("Invalid number of arguments:");
            return;
        }
        boolean  mark[] = new boolean[len];
        for(int i = 0; i < len; i++){
            mark[i] =false;
        }
        for(int i = 0; i < size; i+=2){
            String a = replaceList.get(i);
            String b = replaceList.get(i+1);
            //System.out.println(Arrays.toString(mark));
            while(true){
                int index = strstr(text, a, mark);
                if(index == -1 ) break;
            //System.out.println("find\t" + a);
            //System.out.println("replace\t" + b);
            //System.out.println("Before\t" + text);
            //System.out.println("index\t" + index);
                text = text.substring(0, index) + b + text.substring(index + a.length());
            //System.out.println("After\t" + text);
                boolean newmark[] = new boolean[text.length()];
                markLast(mark, newmark, index, b.length(), a.length());
                mark = newmark;
            }
        }
        //System.out.println(text);
        ret.add(text);
    }
    public void markLast(boolean mark[], boolean newmark[], int start, int bLen, int aLen){
        for(int i = 0, j = 0; i < newmark.length && j < start; i++, j++){
            newmark[i] = mark[j]; 
        }
        for(int i = start; i < newmark.length && i < start + bLen; i++){
            newmark[i] = true;
        }
        for(int i = start + bLen, j = start + aLen; i < newmark.length && j < mark.length; i++, j++){
            newmark[i] = mark[j];
        }
    }
    public int strstr(String text, String a, boolean mark[]){
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
    public void printResult(ArrayList<String> ret){
        for(String str : ret){
            System.out.println(str);
        }
    }
    public static void main(String args[]){
        //System.out.println(pathName);
        Main m = new Main();
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> ret = new ArrayList<String>();
            while((line = in.readLine()) != null){
                m.solve(line, ret);
            }
            in.close();
            m.printResult(ret);
        }catch(IOException e){
            System.out.println("File Read Error: " + e.getMessage());
        }

    }
}
