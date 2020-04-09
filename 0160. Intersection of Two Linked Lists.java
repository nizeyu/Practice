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
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode p = headA;
        int m = 0;
        while (p != null) {
            p = p.next;
            m++;
        }
        
        ListNode q = headB;
        int n = 0;
        while (q != null) {
            q = q.next;
            n++;
        }
        
        int d = m - n;
        
        p = headA;
        q = headB;
        if (d > 0) {
            for (int i = 0; i < d; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < -d; i++) {
                q = q.next;
            }
        }
        
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            
            p = p.next;
            q = q.next;
        }
        
        return null;
    }
}
