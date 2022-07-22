package leetcode.algorithm_pattern.linked_list.reverseList;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 翻转链表
 * @author: ahh556
 * @createDate: 2022/7/21
 * @version: 1.0
 */
public class Solution {
//    以rear节点结尾及之前为已经翻转的节点，
//    以front节点开头及之后的节点为尚未翻转的节点
//    设p为front的下一个节点，
//    之后
//    front.next = rear
//            rear = front
//    front = p
//            p = p.next
//    又回到了开始的状态，直到p = null
//    最后在front.next = rear
//    之后返回front即可

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode rear = null;
        ListNode front = head;
        ListNode p = front.next;
        while (p != null) {
            front.next = rear;
            rear = front;
            front = p;
            p = p.next;
        }
        front.next = rear;
        return front;
    }
    // 定义reverseList函数为返回翻转之后的链表的头结点
    public ListNode reverseListDFS(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rhead;

    }
}
