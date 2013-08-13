import java.util.*;
import java.io.*;
public class Main {
    public static void solve(){
        StringBuilder sb = new StringBuilder();
        int N = 12;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int curr = i * j;
                int padding = 4 - Integer.toString(curr).length();
                for(int k = 0; k < padding; k++){
                    sb.append(" ");
                }
                sb.append(curr);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    public static void main (String[] args) {
        solve();
    }
}
