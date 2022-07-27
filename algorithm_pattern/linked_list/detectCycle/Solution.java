package leetcode.algorithm_pattern.linked_list.detectCycle;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/25
 * @version: 1.0
 */
public class Solution {
    //先找到slow与fast第一次相遇的节点，找到之后设置新节点pre，让pre与slow以相同速度同时向后，相遇点则为尾节点指向的位置
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while (true) {
                    // 注意等于应该先判断，因为可能不用下一步就相等
                    if(slow == pre) {
                        return pre;
                    }
                    slow = slow.next;
                    pre = pre.next;
                }
            }
        }
        return null;
    }
}
