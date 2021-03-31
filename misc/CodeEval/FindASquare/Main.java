import java.util.*;
import java.io.*;
public class Main {
    public static boolean solve(String line){
        int x[] = new int[4];
        int y[] = new int[4];
        String pair[] = line.split(", ");
        for(int i = 0; i < 4; i++){
            String coordinate[] = pair[i].substring(1, pair[i].length() - 1).split(",");
            x[i] = Integer.parseInt(coordinate[0]);
            y[i] = Integer.parseInt(coordinate[1]);
        }
        double dis[] = new double[3];
        dis[0] = (x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]);
        dis[1] = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
        dis[2] = (x[0] - x[3]) * (x[0] - x[3]) + (y[0] - y[3]) * (y[0] - y[3]);
        if(dis[0] == dis[1]){
            return dis[2] == 2 * dis[0];
        }
        if(dis[0] == dis[2]){
            return dis[1] == 2 * dis[0];
        }
        if(dis[1] == dis[2]){
            return dis[0] == 2 * dis[1];
        }
        return false;
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(solve(line));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
