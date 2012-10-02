//Find two sorted Array intersection
import java.util.*;
public class Q73{
    public static ArrayList<Integer> findIntersection(int a[], int b[]){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int aLen = a.length;
        int bLen = b.length;
        while(i < aLen && j < bLen) {
            if(a[i] < b[j]) i++;
            else if(a[i] > b[j]) j++;
            else if(a[i] == b[j]) {
                ret.add(new Integer(a[i]));
                i++;
                j++;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        int aSize = 5;
        int bSize = 10;
        int a[] = new int[aSize];
        int b[] = new int[bSize];
        Random r = new Random();
        for(int i = 0; i < a.length; i++) {
           // a[i] = r.nextInt()%10;
           a[i] = i;
        }
        for(int j = 0; j < b.length; j++) {
            //b[j] = r.nextInt()%10;
            b[j] = j;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        ArrayList<Integer> ret = findIntersection(a, b);
        for(int i = 0; i < ret.size(); i++){
            System.out.print(ret.get(i).toString() + " ");
        }
        System.out.println();
    }
}
