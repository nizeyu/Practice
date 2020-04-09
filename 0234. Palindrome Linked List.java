/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        head2 = reverse(head2);
        
        while(head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode p = head;
        ListNode q = p.next;
        
        while(p != null && q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            
            if(t != null)
                q = t;
            else
                break;
        }
        
        head.next = null;
        
        return p;
    }
}
