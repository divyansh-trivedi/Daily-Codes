import java.util.*;
class Solution {
    class Node{
        int freq;
        char ch;
        Node(int freq , char ch){
            this.freq=freq;
            this.ch=ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq= new PriorityQueue<>((x,y)-> y.freq -x.freq);

        if(a>0)pq.add(new Node(a,'a'));
        if(b>0)pq.add(new Node(b,'b'));
        if(c>0)pq.add(new Node(c,'c'));

        String ans="";

        while(pq.size()>0){
            Node n=pq.poll();
            int count=n.freq;
            char ch=n.ch;
            
     if(ans.length()>=2&& ans.charAt(ans.length()-1)== ch && ans.charAt(ans.length()-2)== ch){
        if(pq.size()==0)break;

        Node temp=pq.poll();
        ans= ans+temp.ch;
        if(temp.freq>1)pq.add(new Node(temp.freq-1, temp.ch));
     }
        else{
        count--;
        ans=ans+ch;
        }
     

     if(count>0)pq.add(new Node(count,ch));
        
        }
        return ans;
    }
}