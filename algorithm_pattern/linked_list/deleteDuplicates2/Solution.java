package leetcode.algorithm_pattern.linked_list.deleteDuplicates2;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description:
 * @author: ahh556
 * @createDate: 2022/7/15
 * @version: 1.0
 */
public class Solution {

//      0或1个节点 直接返回
//      2及以上个节点
//      准备两个指针，前指针指到一个元素时，后指针从前指针的下一个元素开始，查找，直到找不到与前指针相同的元素为止，
//      若没有找到相同的元素则直接不做处理
//      若找到了相同的元素，在将后指针赋值给前指针的前指针
//
//      以上写法只适用于存在前指针的的前指针的情况
//      所以可以添加哑指针，造成必定为前指针的前指针的情况
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode front = head;
        ListNode rear = null;
        ListNode pre = dummy;
        while (front != null && front.next != null) {
            rear = front.next;
            while (rear != null && front.val == rear.val) {
                rear = rear.next;
            }
            if(rear != front.next) {
                pre.next = rear;
                front = pre.next;
            } else {
                pre = front;
                front = front.next;
            }

        }
        return dummy.next;
    }
    public ListNode deleteDuplicatesDfs(ListNode head) {
        return null;
    }

}
