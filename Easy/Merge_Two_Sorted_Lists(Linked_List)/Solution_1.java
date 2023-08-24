// This solution uses an interative approach to merge the two lists
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return tempHead.next;
    }
    // Let m be the number of nodes in list1 and n be the number of nodes in list2
    // Time complexity: O(m + n) - because we are visiting each node in both lists once and all the other operations are constant time
    // Space Complexity: O(1) because we are using constant extra space assuming that we are not considering the output list in our space complexity analysis
}
