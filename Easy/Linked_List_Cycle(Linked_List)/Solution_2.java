// This solution utilizes the Tortoise and Hare Algorithm to figure out if a linked list has a cycle or not
public class Solution_2 {
    public static void main(String[] args) {
        
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
        // Let n be the total number of nodes
        // Time Complexity: O(n) because we are visiting each node once
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }
}
