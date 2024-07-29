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
    public static ListNode reverse (ListNode  head){
        ListNode prev=null,ptr=head;

        while(ptr!=null){
           
            ListNode after=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=after;

        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null && k<=1)
        return head;


       ListNode dummy =new ListNode(-1);
       dummy.next=head;

       ListNode prev=dummy;
        ListNode ptr=head;// grp start

        while(ptr!=null){
            ListNode end=ptr; // grp end 
            for(int i=0;i<k-1 && end!=null ;i++) {
                end=end.next;

            }
            if(end==null)
            break;

            ListNode after=end.next;
            end.next=null;// temp. null

            ListNode head2=reverse(ptr);
          
          prev.next=head2;
           
            ptr.next=after;// ptr connected to next grp

            prev=ptr;// now previous  grp becomes the ending of new grp

            ptr=after;// ptr which acts as head is shifted to starting of new grpl]



        }
        return  dummy.next;


    }
}