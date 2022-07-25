package leetcode.algorithm_pattern.linked_list.reorderList;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 重排链表
 * @author: ahh556
 * @createDate: 2022/7/25
 * @version: 1.0
 */
public class Solution {

//    从0开始计数，n为节点个数
//    若偶数个节点，中间指针到第n/2
//    若奇数个节点，中间指针到第n/2
//    从此节点断开分为左右两个链表left 与 right
//    对right链表进行翻转
//    之后以left链表为主链表，每次取一个节点加入到left链表每一个节点后面

    public void reorderList(ListNode head) {

        // 寻找中节点
        ListNode middle = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开中节点分为left与right
        middle = slow;
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        // 对right进行翻转
        ListNode rear = null;
        ListNode front = right;
        while (front != null) {
            ListNode temp = front.next;
            front.next = rear;
            rear = front;
            front = temp;
        }
        right = rear;
        // 将right中的每一个节点都加入到left中
        ListNode lCur = left;
        ListNode rCur = right;
        while (lCur != null && rCur !=null) {
            ListNode newNode = rCur.next;
            rCur.next = lCur.next;
            lCur.next = rCur;
            rCur = newNode;
            lCur = lCur.next.next;
        }
    }
}
