package leetcode.algorithm_pattern.binary_tree.bst_application.insertIntoBST;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/14
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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        return dfs(root,val);
    }
    // 定义函数为，返回插入了节点之后的树
    public TreeNode dfs(TreeNode root,int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if( val < root.val) {
            root.left = dfs(root.left,val);
        } else {
            root.right = dfs(root.right,val);
        }
        return root;

    }
}
