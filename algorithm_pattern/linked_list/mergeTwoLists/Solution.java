package leetcode.algorithm_pattern.linked_list.mergeTwoLists;

import leetcode.algorithm_pattern.linked_list.ListNode;

/**
 * @description: 升序链表合并
 * @author: ahh556
 * @createDate: 2022/7/22
 * @version: 1.0
 */
public class Solution {

//    设第一个链表为one，第二个链表为two，第三个链表为ans
//    比较one与two的值的大小，小的放到ans中，之后被放的链表下移一个节点。
//    直到一个链表完了，将没有完的链表加入ans尾部即可
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null && list2 != null) {
            return list2;
        }
        if(list1 != null && list2 == null) {
            return list1;
        }
        ListNode ans = null;
        ListNode ansCur = null;
        ListNode l1Cur = list1;
        ListNode l2Cur = list2;
        if(l1Cur.val < l2Cur.val) {
            ans = l1Cur;
            ansCur = ans;
            l1Cur = l1Cur.next;
        } else {
            ans = l2Cur;
            ansCur = ans;
            l2Cur = l2Cur.next;
        }
        while (l1Cur != null && l2Cur != null) {
            if(l1Cur.val < l2Cur.val) {
                ansCur.next = l1Cur;
                l1Cur = l1Cur.next;
                ansCur = ansCur.next;
            } else {
                ansCur.next = l2Cur;
                l2Cur = l2Cur.next;
                ansCur = ansCur.next;
            }
        }
        if(l1Cur != null) {
            ansCur.next = l1Cur;
        }
        if(l2Cur != null) {
            ansCur.next = l2Cur;
        }
        return ans;
    }
    // 定义此函数为合并两个升序列表并且返回最终答案链表的函数
    public ListNode mergeTwoListsDFS(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null && list2 != null) {
            return list2;
        }
        if(list1 != null && list2 == null) {
            return list1;
        }
        ListNode ans = null;
        if(list1.val < list2.val) {
            ans = list1;
            ans.next = mergeTwoListsDFS(list1.next,list2);
        } else {
            ans = list2;
            ans.next = mergeTwoListsDFS(list1,list2.next);
        }
        return ans;
    }
    // 定义此函数为合并两个升序列表并且返回最终答案链表的函数
    public ListNode mergeTwoListsDFS2(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null && list2 != null) {
            return list2;
        }
        if(list1 != null && list2 == null) {
            return list1;
        }
        if(list1.val < list2.val) {
            list1.next = mergeTwoListsDFS2(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoListsDFS2(list1,list2.next);
            return list2;
        }
    }
}
