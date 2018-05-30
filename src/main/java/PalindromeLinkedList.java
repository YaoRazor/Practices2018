import datastructures.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedSecondHalf = reverseList(slow.next);

        while (reversedSecondHalf !=null) {

            if(reversedSecondHalf.val!=head.val) {
                return false;
            }

            reversedSecondHalf = reversedSecondHalf.next;
            head = head.next;

        }

        return true;
    }



    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur = head;

        while(cur!=null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
