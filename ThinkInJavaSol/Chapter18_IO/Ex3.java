import java.util.regex.*;
import java.io.*;
import java.util.*;
public class Ex3{
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter(){
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name){
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String args[]){
        File path = new File(".");
        File[] files;
        String[] list;
        if(args.length == 0){
            files = path.listFiles();
        }else 
            files = path.listFiles(filter(args[0]));
        Arrays.sort(files);
        long sum = 0;
        for(File f : files){
            System.out.print(f + ": ");
            System.out.println(f.length());
            sum += f.length();
        }
        System.out.println("Total size " + sum);
    }
}
