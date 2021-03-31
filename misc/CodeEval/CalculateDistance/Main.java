import java.util.*;
import java.io.*;
public class Main {
    public static String[] split(String s){
        int len = s.length();
        int firstRight = s.indexOf(')');
        String ret[] = new String[2];
        ret[0] = s.substring(1, firstRight);
        s = s.substring(firstRight + 3, len-1);
        ret[1] = s;
        return ret;
    }
    public static Coordinate[] parse(String[] s){
        Coordinate[] c = new Coordinate[2];
        for(int i = 0; i < 2; i++){
            int first = s[i].indexOf(',');
            String x = s[i].substring(0, first);
            String y = s[i].substring(first+2);
            c[i] = new Coordinate(Integer.parseInt(x), Integer.parseInt(y));
        }
        return c;
    }
    public static int solve(Coordinate a, Coordinate b){
        return (int)Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = split(line);
                Coordinate[] c = parse(lineArray);
                System.out.println(solve(c[0], c[1]));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Coordinate{
    int x;
    int y;
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
