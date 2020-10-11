/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec3 {

    String preOrder = "";
    String inOrder = "";
    int index = 0;
    public String serialize(TreeNode root) {
        if(root == null) return null;
        preOrder(root);
        inOrder(root);
        return preOrder + " I " + inOrder;
    }
    public void preOrder(TreeNode root){
        if(root == null) return;
        preOrder += root.val + " ";
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        inOrder += root.val + " ";
        inOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        int index = data.indexOf("I");
        String preOrder = data.substring(0, index);
        String inOrder = data.substring(index + 1);
        int[] preorder = get(preOrder);
        int[] inorder = get(inOrder);
        TreeNode res = helper(preorder, inorder, 0, inorder.length-1);
        return res;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left > right) return null;
        int v = preorder[index];
        TreeNode root = new TreeNode(v);
        int k = find(inorder, v, left, right);
        if(k == -1){
            return null;
        }
        index++;
        root.left = helper(preorder, inorder, left, k - 1);
        root.right = helper(preorder, inorder, k + 1, right);
        return root;
    }
    public int find(int[] inorder, int target, int l, int r){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(inorder[mid] == target){
                return mid;
            }else if(inorder[mid] < target){
                l = mid + 1;
            }else if(inorder[mid] > target){
                r = mid - 1;
            }
        }
        return -1;
    }

    public int[] get(String s){
        s = s.trim();
        String[] sp = s.split(" ");
        int[] arr = new int[sp.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.valueOf(sp[i]);
        }
        return arr;
    }
    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        String s = codec.serialize(root);
        TreeNode r = codec.deserialize(s);
        System.out.println(r.val);

    }
}

