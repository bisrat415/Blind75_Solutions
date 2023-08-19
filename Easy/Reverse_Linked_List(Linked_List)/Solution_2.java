// This solution reverses a linked list recursively
public class Solution_2 {
    public static void main(String[] args) {
        
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHeadOfReversedSublist = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadOfReversedSublist;
        // Time Complexity: O(n)
        // Space Complexity: O(n) - Each recursive function call takes up space in the stack frame and for a list of length n, we make n recursive calls
    }
}
