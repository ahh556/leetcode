package leetcode.algorithm_pattern.linked_list;

import leetcode.algorithm_pattern.linked_list.reorderList.Solution;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/23
 * @version: 1.0
 */
public class Client {

    public static void main(String[] args) {
//        head = [1,4,3,2,5,2], x = 3
//        [-1,5,3,4,0]
        ListNode head = new ListNode(-1);
        ListNode p = head;
        p.next = new ListNode(0);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(9);
        p = p.next;
        p.next = new ListNode(-3);
        p = p.next;
        p.next = new ListNode(10);
        p = p.next;

//        ListNode head1 = new ListNode(-10);
//        ListNode p1 = head1;
//        p1.next = new ListNode(-3);
//        p1 = p1.next;
//        p1.next = new ListNode(5);
//        p1 = p1.next;
//        p1.next = new ListNode(9);
//        p1 = p1.next;
//        p1.next = new ListNode(10);
//        p1 = p1.next;
//        p1.next = new ListNode();
//        p1 = p1.next;

//        ListNode head3 = new Solution().reorderList(head);
        new Solution().reorderList(head);
//        while (head3 != null) {
//            System.out.println(head3.val);
//            head3 = head3.next;
//        }
    }

}
