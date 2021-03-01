import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}

class FreqStack {

    private class Element {
        int value;
        int freq;
        LinkedList<Integer> indexes;

        public Element(int v, int f) {
            this.value = v;
            this.freq = f;
            this.indexes = new LinkedList<>();
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Element{");
            sb.append("value=").append(value);
            sb.append(", freq=").append(freq);
            sb.append(", indexes=").append(indexes);
            sb.append('}');
            return sb.toString();
        }
    }

    List<Integer> list;
    Map<Integer, Element> map;
    PriorityQueue<Element> pq;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq ?
                b.indexes.get(b.indexes.size() - 1) - a.indexes.get(a.indexes.size() - 1) : b.freq - a.freq));
        list = new LinkedList<>();
    }

    public void push(int x) {
        int index = list.size();
        list.add(x);

        if (map.containsKey(x)) {
            Element element = map.get(x);

            element.freq++;
            element.indexes.add(index);
            pq.remove(element);
            pq.add(element);

        } else {
            Element element = new Element(x, 1);
            map.put(x, element);
            element.indexes.add(index);
            pq.add(element);

        }

    }

    public int pop() {
        Element element = pq.poll();
        element.freq--;
        int result = element.value;
        if (element.freq != 0) {
            element.indexes.removeLast();

            pq.add(element);
        } else {
            element.indexes.removeLast();
            map.remove(element);
        }
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such: FreqStack obj = new FreqStack(); obj.push(x); int
 * param_2 = obj.pop();
 */