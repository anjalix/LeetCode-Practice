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
       List<ListNode> list = new ArrayList<ListNode>();
        while(headA!=null) {
            list.add(headA);
            headA = headA.next;
        }
        while(headB!=null) {
            if(list.contains(headB))
                return headB;
            headB = headB.next;
        }        
        return null;
    }
}