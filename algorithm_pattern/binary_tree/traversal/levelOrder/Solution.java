package leetcode.algorithm_pattern.binary_tree.traversal.levelOrder;

import java.util.*;
/**
 * @description: 层序遍历 队列实现 （bfs）
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
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);

        levelOrderPlus(treeNode);

    }
    /**
     * 自己写的题解
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
//        定义：队列头节点为我们需要找最近子节点的节点

//        先把头节点入列，（之后出列做记录（出列的时候有问题）之后把 它的左右子节点入列）
//
//        出列的时候注意，为答案最后元素里面的节点的子节点放在同一的数组，一旦出现了不在最后元素里面的节点，立刻更新最后的数组并且，加入新的空数组

        if(root == null) {
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }
        // 用dfs深度搜索二叉树,poll()将头部元素弹出，add()将在尾部加入元素
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> findList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode firstNode = queue.poll();
            if(flag) {
                findList.add(new ArrayList<>());
                findList.get(0).add(firstNode);
                findList.add(new ArrayList<>());
                flag = !flag;
            } else {
                List<TreeNode> lastList = findList.get(findList.size() - 2);
                for (int i = 0; i < lastList.size(); i++) {
                    if(lastList.get(i).right == firstNode || lastList.get(i).left == firstNode) {
                        findList.get(findList.size() - 1 ).add(firstNode);
                        break;
                    }
                    if(i == lastList.size() - 1) {
                        findList.add(new LinkedList<>());
                        findList.get(findList.size() - 1).add(firstNode);
                    }
                }
            }

            if(firstNode.left != null){
                queue.add(firstNode.left);
            }
            if(firstNode.right != null){
                queue.add(firstNode.right);
            }

        }
        for (int i = 0; i < findList.size(); i++) {
            if(findList.get(i).size() > 0) {
                list.add(new ArrayList<>());
                for (int j = 0; j < findList.get(i).size(); j++) {
                    list.get(i).add(findList.get(i).get(j).val);
                }
            }
        }
        return list;
    }

    /**
     * 根据leetcode题解自己写的答案
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderPlus(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 0;
        int k = 0;
        while (!queue.isEmpty()) {
            length = queue.size();
            list.add(new ArrayList<>(length));
            for (int i = 0; i < length; i++) {

                TreeNode firstNode = queue.poll();
                if(firstNode.left != null) {
                    queue.add(firstNode.left);
                }
                if(firstNode.right != null) {
                    queue.add(firstNode.right);
                }
                list.get(k).add(firstNode.val);
            }
            k++;
        }
        return list;
    }

    /**
     * leetcode官方题解java版
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderPlusPlus(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode firstNode = queue.poll();
                level.add(firstNode.val);
                if(firstNode.left != null) {
                    queue.add(firstNode.left);
                }
                if(firstNode.right != null) {
                    queue.add(firstNode.right);
                }
            }
            list.add(level);
        }
        return list;
    }





}
