import java.io.*;
import java.util.*;
public class Ex7 {
    public static void main(String args[]){
        String filename = args[0];  
        try{
            String input;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            LinkedList<String> result = new LinkedList<String>();
            while((input = br.readLine())!=null){
                result.add(input);
            }
            StringBuilder sb = new StringBuilder();
            while(result.peekLast()!= null){
                sb.append(result.pollLast() + "\n");
            }
            br.close();
            System.out.println(sb.toString());
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
