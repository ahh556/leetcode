package leetcode.algorithm_pattern.linked_list.deleteDuplicates;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 链表删除重复元素
 * @author: ahh556
 * @createDate: 2022/7/15
 * @version: 1.0
 */



public class Solution {
    /**
     * 空节点
     * 直接返回空
     * 1个节点
     * 直接返回
     *
     * 多个节点（大于等于2）
     * 从左往右遍历，如果出现了前等于后则删除后一个节点，注意指针到倒数第二个节点停止，
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;

        while (p.next != null) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
