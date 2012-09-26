import java.util.Arrays;
import java.util.Random;
public class Q3{
    public static Node createBST(int array[], int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);
        node.left = createBST(array, start, mid - 1);
        node.right = createBST(array, mid + 1, end);
        return node;
    }
    public static void traveseBST(Node node) {
        if(node == null)
            return;
        System.out.println(node.value);
        traveseBST(node.left);
        traveseBST(node.right);
    }
    public static void main(String args[]){
        int size = 10;
        int array[] = new int[10];
        Random r = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = r.nextInt(100)%100;
            //System.out.println(array[i]);
        }
        Arrays.sort(array);
        for(int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println("*************************");
        Node root = createBST(array, 0, array.length - 1);
        traveseBST(root);

    }
}
