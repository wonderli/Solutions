import java.util.*;
public class Codec{
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return String.join(",", list);
    }
    public void helper(Node root, List<String> list){
        if(root == null) {
            return;
        }else {
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for(Node child : root.children){
                helper(child, list);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.isEmpty() ) return null;
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        return deserializeHelper(queue);
    }
    public Node deserializeHelper(Queue<String> queue){
        Node root = new Node();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            root.children.add(deserializeHelper(queue));
        }
        return root;
    }

    public static void main(String args[]){
        Codec c = new Codec();
        Node n1 = new Node(5, new ArrayList<>());
        Node n2 = new Node(6, new ArrayList<>());
        List<Node> l = new ArrayList<>();
        l.add(n1);
        l.add(n2);
        Node n3 = new Node(3, l);
        Node n4 = new Node(2, new ArrayList<>());
        Node n5 = new Node(4, new ArrayList<>());
        List<Node> l1 = new ArrayList<>(); 
        l1.add(n3);
        l1.add(n4);
        l1.add(n5);
        Node root = new Node(1, l1);
        System.out.println(c.serialize(root));

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
