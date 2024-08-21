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
    public ListNode deleteDuplicates(ListNode head) {
        head = new ListNode(0, head);
        ListNode curr = head, ans = head;
        while (curr != null && curr.next != null) {
            if (curr == head) {
                curr = curr.next;
                continue;
            }
            if (curr.val != curr.next.val) {
                ans = curr;
            }
            else {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                ans.next = curr.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}