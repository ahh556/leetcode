package leetcode刷题.algorithm_pattern.binary_tree.traversal.inorderTraversal_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 后序遍历
 * @author: ahh556
 * @createDate: 2022/7/7
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

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;
    }
}
