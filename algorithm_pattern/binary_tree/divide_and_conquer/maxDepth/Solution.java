package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.maxDepth;

/**
 * @description: 返回二叉树的最大深度
 * @author: ahh556
 * @createDate: 2022/7/9
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
    private static int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        maxDepth(root);
    }
    public static int maxDepth(TreeNode root) {
//        用dfs搜，并且维护最大值
        dfs(root,0);
        return 0;
    }
    public static void dfs(TreeNode root,int depth) {
        if(max < depth) {
            max = depth;
        }
        if(root == null) {
            return ;
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
    /**
     * 分治
     * @param root
     * @return
     */
    public int dfsDC(TreeNode root) {

        if(root == null) {
            return 0;
        }
        return Math.max(dfsDC(root.left),dfsDC(root.right)) + 1;

    }

}
