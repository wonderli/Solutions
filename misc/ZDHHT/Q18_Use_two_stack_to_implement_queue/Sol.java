import java.util.Stack;
public class Sol{
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;
    Sol(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    void enqueue(int n){
        stack1.push(Integer.valueOf(n));
        size++;
    }
    int dequeue(){
        Integer n;
        int num = 0;
        if(stack2.empty()){
            while(!stack1.empty()){
                Integer e = stack1.pop();
                stack2.push(e);
            }
            n = stack2.pop();
            num = n.intValue();
        }else{
            n = stack2.pop();
            num = n.intValue();
        }
        return num;
    }
    
    public static void main(String args[]){
        Sol s = new Sol();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        s.enqueue(5);
        for(int i = s.size; i > 0; i--){
            Integer e = s.dequeue();
            System.out.println(e.intValue());
        }
    }
}
