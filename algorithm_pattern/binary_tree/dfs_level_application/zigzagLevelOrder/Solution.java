package leetcode.algorithm_pattern.binary_tree.dfs_level_application.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的锯齿形层序遍历
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new ArrayList<>();
            int level = list.size();
            for (int i = 0; i < length; i++) {
                TreeNode tempNode = queue.poll();
                if(level % 2 == 1) {
                    levelList.add(0,tempNode.val);
                } else {
                    levelList.add(tempNode.val);
                }

                TreeNode left = tempNode.left;
                if(left != null) {
                    queue.add(left);
                }
                TreeNode right = tempNode.right;
                if(right != null) {
                    queue.add(right);
                }
            }
            list.add(levelList);
        }

        return list;
    }



}
