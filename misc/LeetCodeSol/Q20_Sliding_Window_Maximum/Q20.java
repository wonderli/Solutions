import java.util.*;
public class Q20{
    public static int[] trackMax(int array[], int w){
        ComparatorPriorityQueue c = new ComparatorPriorityQueue();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(w, c);
        int b[] = new int[array.length - w + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < w; i++){
            q.add(array[i]);
        }
        Integer m = q.peek();
        b[0] = m.intValue();
        System.out.println(q);
        for(int i = 1; i < array.length - w; i++){
            q.remove(new Integer(array[i-1]));
            q.add(new Integer(array[i + w - 1]));
            System.out.println(q);
            m = q.peek();
            b[i] = m.intValue();
        }
        q.clear();
        for(int i = array.length - w; i < array.length; i++){
            q.add(array[i]);
        }
        System.out.println(q);
        m = q.peek();
        b[array.length - w] = m.intValue();
        return b;
    }
    public static void main(String args[]){
        //int array[] = {1, 3, -1, -3, 5, 3, 6, 7, 10, -5, 3};
        int array[] = {3, 3, 3, 3, 5, 3, 6, 7, 10};
        int w = 3;
        int b[] = trackMax(array, 3);
        System.out.println("Array: ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("\nOutput: ");
        for(int i = 0; i < b.length; i++){
            System.out.print(b[i] + ", ");
        }

    }
}
class ComparatorPriorityQueue implements Comparator<Integer>{
    public int compare(Integer x, Integer y){
        if(x.compareTo(y) < 0) return 1;
        else if(x.compareTo(y) == 0) return 0;
        else return -1;
    }
}
