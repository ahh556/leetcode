package leetcode刷题.algorithm_pattern.binary_tree.traversal.dfs_deep_up2down;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: DFS 深度搜索（从上到下） 深度遍历，结果指针作为参数传入到函数内部
 * @author: ahh556
 * @createDate: 2022/7/5
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
        // 用dfs深度搜索二叉树
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    // 定义dfs为 对二叉树进行前序遍历的答案,并且把答案放入list中
    public void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);

    }


}
