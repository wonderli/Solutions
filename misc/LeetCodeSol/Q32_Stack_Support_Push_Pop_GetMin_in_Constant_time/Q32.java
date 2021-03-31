import java.util.*;
public class Q32{
    ArrayDeque<Integer> s;
    ArrayDeque<Integer> min;
    public void push(int num){
        s.addFirst(num);
        if(min.isEmpty() || num < min.peekFirst()){
            min.push(num);
        }
    }
    public int pop(){
        int x = s.removeFirst();
        if(!min.isEmpty() && x == min.peekFirst()){
            min.removeFirst();
        }
        return x;
    }
    public int getMin(){
        if(min.isEmpty()){
            System.out.println("min doesn't exist");
            return -1;
        }else{
            return min.peekFirst();
        }
    }
    public static void main(String args[]){
        Q32 q = new Q32();
        q.s = new ArrayDeque<Integer>();
        q.min = new ArrayDeque<Integer>();
        q.push(3);
        q.push(4);
        q.push(5);
        int x = q.getMin();
        System.out.println(x);
        int y = q.pop();
        System.out.println(y);
        int z = q.getMin();
        System.out.println(z);
    }
}
