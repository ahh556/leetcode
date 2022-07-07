package leetcode刷题.algorithm_pattern.binary_tree.traversal.levelOrder_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 层序遍历递归实现 （dfs）
 * @author: ahh556
 * @createDate: 2022/7/6
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
    /**
     * 深度优先 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,0,root);
        return list;

    }
    public void dfs(List<List<Integer>> list,int index, TreeNode root) {
        if(root == null) {
            return;
        }
        if(list.size() == index) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            list.add(arrayList);
        } else {
            list.get(index).add(root.val);
        }
        dfs(list,index + 1,root.left);
        dfs(list,index + 1,root.right);

    }



}
