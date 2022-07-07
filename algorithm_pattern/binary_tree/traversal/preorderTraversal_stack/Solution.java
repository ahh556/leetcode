package leetcode.algorithm_pattern.binary_tree.traversal.preorderTraversal_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树前序遍历（栈）
 * @author: ahh556
 * @createDate: 2022/7/2
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 不断找左节点，取节点放在stack中，将其加入结果集合，
        // 当没有左节点的时候，取右节点放入栈中，并将值放入集合，取节点放入stack中....
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.empty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
