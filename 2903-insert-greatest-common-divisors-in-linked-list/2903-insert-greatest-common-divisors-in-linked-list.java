/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ptr=head;
        while(ptr.next!=null){
            ListNode prev=ptr;
            ListNode after=ptr.next;
            int gcd= getGCD(prev.val,after.val);
            ListNode newNode= new ListNode(gcd);
            newNode.next=after;
            prev.next=newNode;
            ptr=after;
        }
        return head;
    }
}