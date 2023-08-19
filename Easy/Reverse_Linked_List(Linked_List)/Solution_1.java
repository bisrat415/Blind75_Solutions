// This solution reverse a linked list iteratively using three pointers (prev, curr and next)
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
public class Solution_1 {
    public static void main(String[] args) {
        
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
        // Time Complexity: O(n) because we are visiting each node one and all the operations in the while loop are constant time
        // Space Complexity: O(1) because we are only using constant extra space
    }
    
}
