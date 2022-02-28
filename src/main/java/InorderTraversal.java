
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        visit(root, nodeList);
        return nodeList;
    }
    private void visit(TreeNode node, List<Integer> nodeList){
        if (node == null){
            return;
        }
        // 中序遍历：左->根->右
        visit(node.left, nodeList);
        nodeList.add(node.val);
        visit(node.right, nodeList);

    }
}
