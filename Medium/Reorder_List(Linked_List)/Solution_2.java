// In this solution we use a stack to add all the elements of the linked list 
// And then go back and forth between the linked list and stack to reorder the list

import java.util.*;
public class Solution_2 {
    public static void main(String[] args) {

    }
     public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
    
        while(node != null) {
            stack.add(node);
            node = node.next;
        }
    
        node = head;
    
        while(node != null) {
            ListNode next = node.next;
            ListNode endNode = stack.pop();
        
            node.next = endNode;
            endNode.next = next;
            node = next;
            if(node != null && node.next == endNode) {
                node.next = null;
                break;
            }
        }
        // Time Complexity: O(n) because both while loops take O(n) time because they traverse the linked list once. And the all the operations in the while loop are constant time
        // Space Complexity: O(n) because of the stack
     }
}
