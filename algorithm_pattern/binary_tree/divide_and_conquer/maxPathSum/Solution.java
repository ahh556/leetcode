package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.maxPathSum;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/11
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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfsDC(root);
        return maxSum;
    }


    /**
     * 考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
     * 具体而言，该函数的计算如下。
     * 空节点的最大贡献值等于 0。
     * 非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
     * @param root
     * @return
     */
    public int dfsDC(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int leftMax = Math.max(dfsDC(root.left),0);
        int rigthMax = Math.max(dfsDC(root.right),0);
        int tempMaxSum = root.val + leftMax + rigthMax;
        // leftMax
        // root.val
        // rightMax
        // leftMax + root.val
        // root.val + rightMax
        // leftMax + root.val + rightMax
        if(maxSum < tempMaxSum) {
            maxSum = tempMaxSum;
        }

        return root.val + Math.max(leftMax,rigthMax);
    }
}
