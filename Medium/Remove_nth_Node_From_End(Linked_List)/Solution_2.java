// This is a one-pass approach that tries to find the node before the node we want to delete with two pointers so that we can delete the required node  
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
public class Solution_2 {
    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        ListNode left = head;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
    // Time Complexity: O(n) because we are iterating through the whole linked list once and all the operations in the loops are constant time
    // Space Complexity: O(1) because we only utilized constant extra space

}
