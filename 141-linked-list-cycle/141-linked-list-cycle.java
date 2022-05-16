/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(slowPtr!= null && fastPtr!=null)
        {
            slowPtr = slowPtr.next;
            if(fastPtr!=null)
                fastPtr = fastPtr.next;
            if(fastPtr!=null)
                {
                fastPtr = fastPtr.next;
                if(slowPtr == fastPtr)
                    return true;
                }
        }
        return false;
    }
}