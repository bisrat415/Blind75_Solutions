// This is a solution for Q.234(Palindrome Linked List) from leetcode
// The first solution uses an arraylist to copy the stuff from the linkedlist and then compares using the index functionality of arraylists
// The second solution solves the problem in place by reversing the second half of the linkedlist and comparing the two halves

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }
    
    // Solution #1 (Arraylist)
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
        // Time Complexity: O(n) - we are traversing through each element in the linked list twice and all the operations in the loops are constant time
        // Space Complexity: O(n) because of the arraylist
    }

    // Solution #2 (In-place) - reverse the second half and compare the two halves
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = findMiddle(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode currOne = head;
        ListNode currTwo = secondHalfStart;
        boolean ans = true;
        while (currTwo != null) {
            if (currOne.val != currTwo.val) {
                ans = false;
                break;
            }
            currOne = currOne.next;
            currTwo = currTwo.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart); // Used for restoring the list (it's always a good habit to put the input back to it's original state)
        return ans;
        // Time Complexity: O(n) - both helper methods (findMiddle and reverseList) and the while loop as well take O(n/2) time and we can drop the constant coefficient to get O(n)
        // Space Complexity: O(1) - we are only using constant extra space because we solved the problem in-place
    }

    // Helper method for Solution #2
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
         ListNode slow = head;
         while (fast.next != null && fast.next.next != null) {
             fast = fast.next.next;
             slow = slow.next;
         }
         return slow;
    }

    // Helper method for Solution #2
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
