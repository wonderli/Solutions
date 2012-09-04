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
        if(Math.abs(diff) == 1){
            return Math.max(leftHeight, rightHeight) + 1;
        }else {
            return -1;
        }
    }
    public static boolean checkBalance(Node root){
        if(checkHeight(root) != -1){
            return true;
        }
        else
            return false;
    }
    public static void main(String args[]) {

    }
}
