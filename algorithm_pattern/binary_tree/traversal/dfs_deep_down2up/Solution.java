package leetcode刷题.algorithm_pattern.binary_tree.traversal.dfs_deep_down2up;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: dfs深度搜索从下到上（分支） ,DFS 深度搜索（从上到下） 和分治法区别：前者一般将最终结果通过指针参数传入，后者一般递归返回结果最后合并
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
        list = dfs(root);
        return list;
    }
    // 定义dfs为 对二叉树进行前序遍历的答案,并且把答案放入list中
    // 定义递归三步法
    public List<Integer> dfs(TreeNode root) {
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
