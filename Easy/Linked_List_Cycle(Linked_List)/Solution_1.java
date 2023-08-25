// This is a solution that uses a hashset to figure out if there is a cycle or not
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution_1 {
    public static void main(String[] args) {
        
    }
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
        // Let n be the total number of nodes
        // Time Complexity: O(n) because we are visiting each node once
        // Space Complexity: O(n) because we initialised a new hashset where we store each node in the linked list 
    }
}
