class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save the next node
            curr.next = prev;              // 2. Reverse the current link
            prev = curr;                   // 3. Move prev forward
            curr = nextTemp;               // 4. Move curr forward
        }

        return prev; // prev is the new head of the reversed list
    }
}