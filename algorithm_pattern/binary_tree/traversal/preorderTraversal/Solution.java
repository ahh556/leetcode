package leetcode刷题.algorithm_pattern.binary_tree.traversal.preorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树前序遍历
 * @author: ahh556
 * @createDate: 2022/7/2
 * @version: 1.0
 */

//  Definition for a binary tree node.
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;
    }
}
