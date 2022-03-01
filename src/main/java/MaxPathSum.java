import java.util.HashMap;

public class MaxPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        visit(root);
        return maxSum;
    }
    private int visit(TreeNode root){
        if (root == null){
            return 0;
        }
        int valLeft = visit(root.left);
        int valRight = visit(root.right);
        int val = root.val;
        if (valLeft > 0){
            val += valLeft;
        }
        if (valRight > 0){
            val += valRight;
        }
        if (val > maxSum){
            maxSum = val;
        }
        if (valLeft > valRight && valLeft + root.val > 0){
            return valLeft + root.val;
        }else if (valLeft <= valRight && valRight + root.val > 0){
            return valRight + root.val;
        }else if (root.val > 0){
            return root.val;
        }else{
            return 0;
        }
    }
}
