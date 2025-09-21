class Pair{
    TreeNode first;
    long second;
    Pair(TreeNode first, long second){
        this.first  = first;
        this.second = second;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        long ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            long min  = q.peek().second;

            long first=0,last=0;
            for(int i=0;i<size;i++){
                TreeNode r = q.peek().first;
                long id = q.peek().second;
                q.poll();

                if(i == 0)first = id;
                if(i == size-1)last = id;

                if(r.left != null)q.offer(new Pair(r.left,id*2+1));
                if(r.right != null)q.offer(new Pair(r.right,id*2+2));
            }
            ans = Math.max(last-first+1,ans);
        }
        return (int)ans;
    }
}