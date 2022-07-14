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
        
        while(true) {
            if(slowPtr != null)
                slowPtr = slowPtr.next;
            if(fastPtr != null)
                fastPtr = fastPtr.next;
            if(fastPtr == null)
                return false;
            fastPtr = fastPtr.next;
            if(slowPtr!=null && fastPtr == null)
                return false;            
            if(slowPtr == fastPtr)
                return true;
        }
    }
}