package leetcode.algorithm_pattern.binary_tree.divide_and_conquer.isBalanced;

/**
 * @description:
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

    private Boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }
    // 定义dfs为返回传入子树的高度

    /**
     * 深度搜索
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int ldepth = dfs(root.left);
        int rdepth = dfs(root.right);
        if(Math.abs(ldepth - rdepth) >1) {
            flag = false;
        }
        return Math.max(ldepth,rdepth) + 1;

    }

    /**
     * 判断是否为平衡树
     * @param root
     * @return
     */
    // 定义dfs函数为返回树的高度或是否平衡， >= 0 则为高度  ，<0 则为不平衡
    public int dfsPlus(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int lh = dfsPlus(root.left);
        int rh = dfsPlus(root.right);
        if(Math.abs(lh - rh) > 1 || lh == -1 || rh == -1) {
            return -1;
        } else {
            return Math.max(lh,rh) + 1;
        }
    }



}
