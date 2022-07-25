package leetcode.algorithm_pattern.linked_list;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/15
 * @version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
