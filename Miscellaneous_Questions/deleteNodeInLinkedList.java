// Question: There is a singly-linked list head and we want to delete a node in it.
// For the full description look at 237. Delete Node in a Linked List on leetcode

// This is the definition for a singly linked list
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

// This solution solves the problem by copying the value of the next node to the provided node and deleting the next node (In the end it looks as if you deleted the given node)
public class deleteNodeInLinkedList {
    public static void main(String[] args) {
        
        
    }
    public static void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp.next = null;
    }
}


