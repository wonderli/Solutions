import java.util.*;
public class Ex2 {
    public static void main(String[] args) {
        Random r = new Random();
        Collection<Integer> c = new HashSet<Integer>();
        for(int i = 0; i < 10; i++){
            int num = r.nextInt()%10;
            c.add(num);
            System.out.print(num + " ");
        }
        System.out.println();
        for(Integer i : c)
            System.out.print(i + " ");
        System.out.println();
    }
}
