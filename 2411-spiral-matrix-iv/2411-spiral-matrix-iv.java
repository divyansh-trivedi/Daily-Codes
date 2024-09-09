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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ar[][]= new int[m][n];
        for(int i[]:ar)
        Arrays.fill(i,-1);
int tr=0,br=m-1,lc=0,rc=n-1;
// toprow=tr ; bottom row= br; left coloumn =lc; right coloumn =rc;

        while(head!=null){
            // fill top row-->tr
            for(int col=lc;col<=rc&&head!=null;col++ ){
               ar[tr][col]=head.val;
               head=head.next;
            }
            tr++;

            // fill bottom  column=== bc 
            for(int row=tr;row<=br&&head!=null;row++){
                ar[row][rc]=head.val;
                head=head.next;
            }
            rc--;

            // fill bottom row== br
            for(int col=rc;col>=lc&&head!=null;col--){
               ar[br][col]=head.val;
               head=head.next;
            }
            br--;

            // fill left coloumn 
            for(int row=br;row>=tr&&head!=null;row--){
                ar[row][lc]=head.val;
                head=head.next;
            }
            lc++;


        }
        return ar;

        
    }
}