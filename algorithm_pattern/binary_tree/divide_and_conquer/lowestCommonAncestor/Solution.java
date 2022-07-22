package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.lowestCommonAncestor;

/**
 * @description: 寻找公共祖先，这题不会写、
 * @author: ahh556
 * @createDate: 2022/7/12
 * @version: 1.0
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        return dfs(root,p,q);
    }
    // 定义dfs 找p，q两个节点，同时找到了两个节点
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right,p,q);
//        在同侧
        if (left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
//        在一侧
        if(left != null && right != null) {
            return root;
        }
        return null;
    }
}
