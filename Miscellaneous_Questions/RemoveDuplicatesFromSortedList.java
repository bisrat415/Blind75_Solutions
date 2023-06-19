// This file solves Q.83 (Remove Duplicates from Sorted List) from leetcode
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
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
        // Let n be the number of the nodes in the linked list
        // Time Complexity: O(n) because each node in the list is checked exactly once to determine if it is a duplicate or not
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }
}
