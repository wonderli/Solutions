import java.util.*;
class p3_6{
    Stack<Integer> s;
    Stack<Integer> r;
    public p3_6(){
        s = new Stack<Integer>();
        r = new Stack<Integer>();
    }
    public Stack<Integer> sort() {
        while(!s.empty()){
            int tmp = s.pop();
            while(!r.empty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
    public static void main(String[] args) {
        p3_6 p = new p3_6();
        int size = 10;
        Random r = new Random(1024);
        for(int i = 0; i < size; i++) {
            int data = Math.abs(r.nextInt()%10);
            if(data == 0){
                i--;
                continue;
            }
            p.s.push(data);
            System.out.println("PUSH " + data);
        }
        p.sort();
        System.out.println(p.r.toString());
        while(!p.r.empty()) {
            System.out.println(p.r.pop());
        }
    }
}
