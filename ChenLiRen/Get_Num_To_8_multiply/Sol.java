import java.util.*;
public class Sol{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int input = in.nextInt(); 
            int result = (input/8 + ((input%8 == 0) ? 0:1)) * 8;
            System.out.println(result);
        }
    }
}
