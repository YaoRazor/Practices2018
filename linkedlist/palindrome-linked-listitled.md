# Palindrome Linked Listitled

If there is no restriction on space , this problem would be easy to implement, for example, you an add all value to a list and check whether the list is a palindrome. When we have to solve the problem with O\(1\) space, then the problem becomes a little bit tricky. You have to find the mid point of the LinkedList and reverse the list from there. However technically in practice, it is dangerous to change the input object. You normally want to keep the input as immutable.

```text
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

        // Always reverse slow.next
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
```

