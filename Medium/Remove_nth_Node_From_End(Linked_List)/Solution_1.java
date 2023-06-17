// This is a two pass approach where we find the length of the linked list on the first pass
// And then go to length - nth node and delete the node after it
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n == length) {
            return head.next;
        }
        int diff = length - n - 1;
        ListNode prev = head;
        for (int i = 0; i < diff; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
    // Let n be the number of nodes in the linked list
    // Time Complexity: O(n) because we are iterating through the whole linked list in the first forloop which takes O(n) time. 
    // And then we have another loop that is used to remove nth node which also takes O(n) in the worst case
    // Space Complexity: O(1) because we are only using constant extra space
}
