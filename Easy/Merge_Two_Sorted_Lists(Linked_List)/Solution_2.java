// This solution uses a recursive approach to merge the two lists in order
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoLists(list1, list2);
        return head;
        // Let m be the number of nodes in list1 and n be the number of nodes in list2
        // Time complexity: O(m + n) - because we are visiting each node in both lists once and all the other operations in the recursive method are constant time
        // Space Complexity: O(m + n) because we have at most m + n recursive calls and every recursive call takes up space in the call stack  
    }
}
