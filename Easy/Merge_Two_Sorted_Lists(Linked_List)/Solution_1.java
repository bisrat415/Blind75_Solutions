// This solution uses an interative approach to merge the two lists
public class Solution_1 {
    public static void main(String[] args) {
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}
