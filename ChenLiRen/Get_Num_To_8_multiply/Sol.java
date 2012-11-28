//写出一行程序语言（任何编成语言都行）表达式，把一个数提升到8的倍数。如1->8, 8->8, 11->16, 23->24。
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
