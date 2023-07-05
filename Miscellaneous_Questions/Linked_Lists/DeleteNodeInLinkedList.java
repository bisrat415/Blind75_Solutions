// Question: There is a singly-linked list head and we want to delete a node in it.
// For the full description look at 237. Delete Node in a Linked List on leetcode

// This is the definition for a singly linked list
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

// This solution solves the problem by copying the value of the next node to the provided node and deleting the next node (In the end it looks as if you deleted the given node)
public class DeleteNodeInLinkedList {
    public static void main(String[] args) {

        
    }
    public static void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp.next = null;
        // If we are not worried about making the next pointer for temp null we can just do it in two lines like this:
        // node.val = node.next.val;
        // node.next = node.next.next;
    }
    // Time Complexity: O(1) because all the operations are constant time (don' t depend on the input size)
    // Space Complexity: O(1) because we only utilized constant extra space 
}


