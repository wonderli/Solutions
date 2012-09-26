import java.util.*;
interface Selector {
    boolean end();
    Object current();
    void next();
}      

public class Sequence {
    private ArrayList<Object> items = new ArrayList<Object>();
    public void add(Object x) {
        items.add(x);
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }    
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        Selector selector = sequence.selector();
        for(int i = 0; i < 10; i++)
            sequence.add(i);
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
        sequence.add("Hello");
        sequence.add("World");
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
    }
} 

