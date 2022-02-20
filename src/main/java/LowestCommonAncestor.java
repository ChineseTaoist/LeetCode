import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q){
            return p;
        }
        ArrayList<TreeNode> ancestorsP = new ArrayList<TreeNode>();
        HashSet<TreeNode> ancestorsQ = new HashSet<TreeNode>();
        findNodesArray(ancestorsP, root, p);
        findNodesSet(ancestorsQ, root, q);
        for (int i = 0; i < ancestorsP.size(); i++){
            if (ancestorsQ.contains(ancestorsP.get(i))){
                return ancestorsP.get(i);
            }
        }
        return root;
    }
    boolean findNodesArray(ArrayList<TreeNode> ancestors, TreeNode root, TreeNode p){
        if (root == p){
            ancestors.add(root);
            return true;
        }
        if (root.left != null && findNodesArray(ancestors, root.left, p)){
            ancestors.add(root);
            return true;
        }
        if (root.right != null && findNodesArray(ancestors, root.right, p)){
            ancestors.add(root);
            return true;
        }
        return false;
    }
    boolean findNodesSet(HashSet<TreeNode> ancestors, TreeNode root, TreeNode p){
        if (root == p){
            ancestors.add(root);
            return true;
        }
        if (root.left != null && findNodesSet(ancestors, root.left, p)){
            ancestors.add(root);
            return true;
        }
        if (root.right != null && findNodesSet(ancestors, root.right, p)){
            ancestors.add(root);
            return true;
        }
        return false;
    }
}
