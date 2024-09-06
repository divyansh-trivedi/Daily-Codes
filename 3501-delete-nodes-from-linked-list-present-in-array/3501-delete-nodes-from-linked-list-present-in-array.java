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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set= new HashSet<>();
        for(int i:nums)set.add(i);

        ListNode dummy= new ListNode();
        dummy.next=head;
         
         ListNode prev=dummy;

         while(head!=null){
            if(set.contains(head.val)){
                // if(head.next==null){
                //     head=null;
                //     head=head.next;
                // }
                prev.next=prev.next.next;
                head=prev.next;
            }
            else{
                prev=head;
            head=head.next;
            }
         }
         return dummy.next;

    }
}