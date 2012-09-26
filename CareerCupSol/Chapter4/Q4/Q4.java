import java.util.ArrayList;
import java.util.LinkedList;
public class Q4 {
    public static ArrayList<LinkedList<Node>> createLevelTree(Node root){
        ArrayList<LinkedList<Node>> ret = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> current = new LinkedList<Node>();
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0) {
            ret.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<Node>();
            for(Node parent: parents) {
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){

    }
}
