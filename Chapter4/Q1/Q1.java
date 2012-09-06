public class Q1{
    public static int checkHeight(Node root) {
        if(root == null) return 0;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1;
        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1){
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public static boolean checkBalance(Node root){
        if(checkHeight(root) == -1){
            return false;
        }
        else
            return true;
    }
    public static Node buildTree() {
        Node root = new Node(1);
        Node[] nodes = new Node[10];
        for(int i = 0; i < 10; i++) {
            nodes[i] = new Node(i + 1);
        }
        root.left = nodes[1];
        root.right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[3].left = nodes[5];
        nodes[4].right = nodes[6];

        nodes[2].left = nodes[7];
        nodes[2].right = nodes[8];

        nodes[7].left = nodes[9];
        nodes[8].right = nodes[0];
        return root;
    }
    public static void main(String args[]) {
        Node root = buildTree();
        Boolean result = checkBalance(root);
        System.out.println(result);
    }
}
