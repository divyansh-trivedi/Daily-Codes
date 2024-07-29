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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode ptr=head;

        while(ptr!=null){
            size++;
            ptr=ptr.next;
        }
        size=size-n;
        if(size==0)return head.next;
ListNode prev=null;
int i=1;
ptr=head;

        while(ptr!=null){
            if(size==i){
ListNode temp=ptr.next.next;
                ptr.next=temp;


            }
            ptr=ptr.next;
            i++;
        }
        return head;
    }
}