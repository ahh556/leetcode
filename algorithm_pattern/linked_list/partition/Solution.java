package leetcode.algorithm_pattern.linked_list.partition;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。


 * @author: ahh556
 * @createDate: 2022/7/23
 * @version: 1.0
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // 加入一个哑节点，在开头处，
        // 设置一个答案节点，如果在原链表中如果小于x将其加入答案中，并且在原链表中删除此元素
        // 遍历一遍后，将头节点接入到答案节点的尾节点
        // 做链表的题目一定要画图！！！
        // 提取公共逻辑时应该看清楚提取之后会不会改变原来的语句顺序，如果改变则不能提取 ！！！
        // 题目范围一定要认真看清楚
        ListNode dNode = new ListNode(201);
        dNode.next = head;
        ListNode cur = dNode;
        ListNode pre = null;
        ListNode ans = new ListNode(0);
        ListNode ansCur = ans;
        while (cur != null) {
            if(cur.val < x) {
                ansCur.next = cur;
                pre.next = cur.next;
                ansCur = ansCur.next;
                // 需要注意此时不需要pre = cur，因为删除了节点pre没改变
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        ansCur.next = dNode.next;
        return ans.next;
    }

}
