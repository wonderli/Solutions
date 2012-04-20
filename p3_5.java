import java.util.*;
class p3_5{
    public Stack<Integer> stackA;
    public Stack<Integer> stackB;
    public int size;
    public p3_5(){
        size = 10;
        this.stackA = new Stack<Integer>();
        this.stackB = new Stack<Integer>();
    }
    public void in(int data){
        if(stackA.size() < size) {
            stackA.push(data);
        }
        else {
            for(int i = 0; i < size; i++) {
                int d = stackA.pop();
                stackB.push(d);
            }
            stackA.push(data);
        }
    }
    public int out(){
        if(stackB.empty()) {
            for(int i = 0; i < size; i++) {
                int d = stackA.pop();
                stackB.push(d);
            }
            return stackB.pop();
        } else {
            return stackB.pop();
        }
    }
    public static void main(String[] args) {
        p3_5 p = new p3_5();
        for(int i = 0; i < 20; i++) {
            p.in(i);
        }
        for(int i = 0; i < 20; i++) {
            System.out.println(p.out());
        }

    }
}
