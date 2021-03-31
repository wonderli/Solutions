public class Node{
    public Node left;
    public Node right;
    public int value;
    public Node(){
        left = null;
        right = null;
        value = 0;
    }
    public Node(int v){
        left = null;
        right = null;
        value = v;
    }
    public static void main(String args[]) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.right.value);

    }
}
