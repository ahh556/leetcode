package leetcode.algorithm_pattern.linked_list.hasCycle;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 环形链表
 * @author: ahh556
 * @createDate: 2022/7/25
 * @version: 1.0
 */
public class Solution {
//    快慢指针，快慢指针相同则有环，证明：如果有环每走一步快慢指针距离会减 1
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
