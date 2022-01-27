import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
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
    public ArrayList<Integer> getRootsVal(ArrayList<TreeNode> roots){
        ArrayList<Integer> rootsVal = new ArrayList<Integer>();
        for (TreeNode root: roots){
            rootsVal.add(root.val);
        }
        return rootsVal;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> tree = new ArrayList<List<Integer>>();
        if (root == null){
            return tree;
        }
        ArrayList<TreeNode> roots = new ArrayList<TreeNode>();
        roots.add(root);
        tree.add(this.getRootsVal(roots));
        while (true){
            ArrayList<TreeNode> nextRoots = new ArrayList<TreeNode>();
            for (TreeNode node: roots){
                if (node.left != null) nextRoots.add(node.left);
                if (node.right != null) nextRoots.add(node.right);
            }
            if (nextRoots.size() == 0){
                break;
            }
            roots = nextRoots;
            tree.add(this.getRootsVal(roots));
        }
        return tree;
    }
}
