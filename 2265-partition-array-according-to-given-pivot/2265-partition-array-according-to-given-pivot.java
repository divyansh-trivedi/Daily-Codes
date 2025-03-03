class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> st1= new LinkedList<>();
        Queue<Integer> st2= new LinkedList<>();
        Queue<Integer> st3= new LinkedList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot)st1.offer(nums[i]);
            else if(nums[i]> pivot)st2.offer(nums[i]);
            else st3.offer(nums[i]);
        }
        int ar[] = new int[nums.length];
        int k=0;
        while(!st1.isEmpty())ar[k++] = st1.poll();
        while(!st3.isEmpty())ar[k++] = st3.poll();
        while(!st2.isEmpty())ar[k++] = st2.poll();

        return ar;
    }
}