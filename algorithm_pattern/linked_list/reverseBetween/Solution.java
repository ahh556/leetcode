package leetcode.algorithm_pattern.linked_list.reverseBetween;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 区间内翻转链表
 * @author: ahh556
 * @createDate: 2022/7/21
 * @version: 1.0
 */
public class Solution {
    // 1. 先遍历到left的前一个节点之后记录left
    // 2. 完成left，right区间内的链表翻转
    // 3. 将翻转之后的链表头部与left的前一个节点相连，将翻转之后的链表尾部与right之后的节点相连
    // 4. 注意此时无法满足只有一个节点，与left从1开始的情况
    // 4.1 对于一个节点做特判
    // 4.2 而left从1开始的情况通过加入哑节点，将此情况转化为不从1开始的情况。从而适用于上面的逻辑，
    //     但是同时也应该考虑，转化之后原本的情况是否适用于上面的逻辑，很明显适用，所以加入哑节点即可

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) {
            return head;
        }
        ListNode dNode = new ListNode(0);
        dNode.next = head;
        left = left + 1;
        right = right + 1;
        int i = 1;
        ListNode p = dNode;
        while (i++ < left - 1) {
            p = p.next;
        }
        ListNode cur = null;
        ListNode pre = p.next;
        ListNode storeOrginPre = pre;
        ListNode temp;
        while (pre != null && i++ <= right) {
            temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        p.next = cur;
        storeOrginPre.next = pre;
        return dNode.next;
    }
}
