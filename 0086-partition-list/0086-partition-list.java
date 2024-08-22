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
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode bef_curr = before;
        ListNode af_curr = after;
        while(head != null) {
            if(head.val < x) {
                bef_curr.next = head;
                bef_curr = bef_curr.next;
            } else {
                af_curr.next = head;
                af_curr = af_curr.next;
            }
            head = head.next;
        }
        af_curr.next = null;
        bef_curr.next = after.next;
        return before.next;
    }
}