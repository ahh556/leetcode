package leetcode.algorithm_pattern.binary_tree.bst_application.isValidBST;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/13
 * @version: 1.0
 */

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
public class Solution {

    public boolean isValidBST(TreeNode root) {

        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    // 定义函数为以root为根节点，判断子树所有的节点是否都在（l，r）的范围内，其中l为子树最小值，r为子树最大值。
    // 注意需要用long，int范围不够，对于左子树lower没有意义，对于右子树uper没有意义，但是，左子树需要uper，右子树需要lower，所以需要这两个参数
    public boolean dfs(TreeNode root,long lower,long uper) {
        if(root == null) {
            return true;
        }
        if(root.val <= lower || root.val >= uper) {
            return false;
        }
        boolean left = dfs(root.left,lower,root.val);
        boolean right = dfs(root.right, root.val, uper);

        return left && right;

    }
}
