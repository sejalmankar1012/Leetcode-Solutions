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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);  // Create a dummy node to simplify handling the edge case of reversing from the head.
        dummy.next = head;
        ListNode prevLeft = dummy;  // The node before the left position.
        
        // Move prevLeft to the node just before the left position.
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        ListNode current = prevLeft.next;
        ListNode nextNode = null;
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            nextNode = current.next;
            current.next = prev;  // Reverse the next pointer.
            prev = current;
            current = nextNode;
        }

        // Connect the reversed portion back to the original list.
        prevLeft.next.next = current;
        prevLeft.next = prev;

        return dummy.next;
    }
}
