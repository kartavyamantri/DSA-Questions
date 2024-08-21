/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode old = head;
        int length = 1;
        while(old.next != null) {
            old = old.next;
            length++;
        }
        old.next = head;
        ListNode newT = head;
        for(int i = 0; i < length - k % length - 1; i++) {
            newT = newT.next;
        }
        ListNode result = newT.next;
        newT.next = null;
        return result;
    }
}