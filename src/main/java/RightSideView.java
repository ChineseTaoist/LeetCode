import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RightSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        order(root, 1, nodeList);
        return nodeList;
    }
    private void order(TreeNode root, int deep, ArrayList<Integer> nodeList){
        if (root == null){
            return;
        }
        if (deep > nodeList.size()){
            nodeList.add(0, root.val);
        }
        order(root.right, deep + 1, nodeList);
        order(root.left, deep + 1, nodeList);
    }
}
