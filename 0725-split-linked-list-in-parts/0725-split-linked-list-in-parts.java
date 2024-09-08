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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;
ListNode[] list= new ListNode[k];
        ListNode ptr=head;
        while(ptr!=null){
            ptr=ptr.next;
            size++;
        }
         int idx=0;
         ListNode current=head;
        int parts=size/k;
        int extra=size%k;

         while(current!=null&&idx<k){
          list[idx]=current;
          int range=parts+(extra>0?1:0);
          extra--;
          
          for(int i=1;i<range;i++){
           if(current.next!=null)
           current=current.next;
          }

          if(current!=null){
            ListNode after=current.next;
            current.next=null;
            current=after;
          }
          idx++;
      
  }
          
         return list;
    }
}