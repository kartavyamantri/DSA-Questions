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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode temp = result;

        for(int i = 0; i < n; i++) head = head.next;

        while(head != null) {
            head = head.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return result.next;
    }
}