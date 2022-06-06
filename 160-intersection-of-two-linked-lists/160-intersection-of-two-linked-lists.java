/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     List<ListNode> storage = new ArrayList<ListNode>();
        ListNode a = headA;
        ListNode b = headB;
        while(a!= null && b!=null){
            if(!storage.contains(a))
                storage.add(a);
            else
                return a;
            if(!storage.contains(b))
                storage.add(b);
            else
                return b;
            a = a.next;
            b = b.next;
        }
        
        while(a!= null){
            if(!storage.contains(a))
                storage.add(a);
            else
                return a;
            a = a.next;
        }
        
        while(b!= null){
            if(!storage.contains(b))
                storage.add(b);
            else
                return b;
            b = b.next;
        }
       return null; 
    }
}