package leetcode.algorithm_pattern.binary_tree.traversal.postorderTraversal_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 中序遍历，栈实现
 * @author: ahh556
 * @createDate: 2022/7/4
 * @version: 1.0
 */

class TreeNode {
//    先一直找左子树，直到找不到左子树了就找右子树，左右子树都找不到了就返回。重新开始找.
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            root = root.right;
            list.add(stack.pop().val);
        }

        return list;
    }
}
