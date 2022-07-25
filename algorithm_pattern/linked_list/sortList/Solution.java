package leetcode.algorithm_pattern.linked_list.sortList;

import leetcode.algorithm_pattern.linked_list.ListNode;

import java.util.List;

/**
 * @description: 归并排序（链表版）
 * @author: ahh556
 * @createDate: 2022/7/24
 * @version: 1.0
 */
public class Solution {


    // 定义sortList为将链表进行排序
    // 注意寻找中节点条件为two != null && two.next != null，且 two从第二个节点开始，one从第一个节点开始，会表现为从0开始向下取整
    // 注意递归式middle.next == null，递归终止条件为 head != null || head.next != null
    public ListNode sortList(ListNode head) {

        return sort(head);

    }
    public ListNode sort(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        // 断开中间的节点
        ListNode tail = middle.next;
        middle.next = null;
        ListNode left = sort(head);
        ListNode right = sort(tail);
        return mergetList(left,right);
    }
    public ListNode mergetList(ListNode headL, ListNode headR) {
        ListNode head = null;
        ListNode cur = null;
        if(headL.val < headR.val) {
            head = headL;
            headL = headL.next;
            head.next = null;
        } else {
            head = headR;
            headR = headR.next;
            head.next = null;
        }
        cur = head;
        while (headL != null && headR != null) {
            if(headL.val < headR.val) {
                cur.next = headL;
                headL = headL.next;
                cur = cur.next;
                cur.next = null;
            } else {
                cur.next = headR;
                headR = headR.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        if(headL != null) {
            cur.next = headL;
        }
        if (headR != null) {
            cur.next = headR;
        }
        return head;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode one = head;
        ListNode two = head.next;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
}
