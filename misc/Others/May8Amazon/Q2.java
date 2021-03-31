/*
This is from one of my friend interview
Question: Give an array, find is there exists two number which sum is equal to x.
*/
import java.util.*;
class Q2{
    public int a;
    public int b;
    public int binary_search(int[] array, int start, int end, int key) {
        if(start <= end) { 
            int mid = start + (end - start)/2;
            if(array[mid] == key) 
                return mid;
            else if(array[mid] < key) {
                return binary_search(array, mid + 1, end, key);
            }
            else if(array[mid] > key) {
                return binary_search(array, start, mid - 1, key);
            }
        }
        return -1;
    }
    public HashSet<Q2> search(int[] array, int sum) {
        Arrays.sort(array);
        HashSet<Q2> list = new HashSet<Q2>();
        for(int i = 0; i < array.length; i++) {
            int sub = sum - array[i];
            if(binary_search(array, 0, array.length - 1, sub) != -1){
            //if(Arrays.binarySearch(array, 0, array.length - 1, sub)!= -1){
                Q2 q = new Q2();
                q.a = array[i];
                q.b = sub;
                list.add(q);
            }
        }
        return list;
    }
    public static void main(String[] args){
        int[] array = {3, 4, 5, 6, 7, 1, 2, 8, 9, 0};
        int sum = 12;
        Q2 q = new Q2();
        HashSet<Q2> list = q.search(array, sum);
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            Q2 x = (Q2)iter.next();
            System.out.println("(" + x.a + ", " + x.b + ")");

        }
//        System.out.println("ARRAY SIZE" + array.length);
//        for(int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//        int key = 3;
//        System.out.println("BINARY SEARCH: " + key + " Result " + q.binary_search(array, 0, array.length-1, key));


    }
}
