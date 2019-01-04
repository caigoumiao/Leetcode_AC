package _851_to_900;

/**
 * @author larry
 * @date 2018-01-04
 * @url https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @title 897. 递增顺序查找树
 */
public class _897
{
    public TreeNode increasingBST(TreeNode root) {
        TreeNode t=new TreeNode(0);
        TreeNode res=t;
        dfs(t, root);
        return res.right;
    }

    public TreeNode dfs(TreeNode res, TreeNode node) {
        if(node == null) return res;
        res=dfs(res, node.left);
        res.right=new TreeNode(node.val);
        return dfs(res.right, node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
