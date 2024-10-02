class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingDouble(o->o[1]));
        // Arrays.sort(arr,(a,b)->a[1]-b[1]);
        // Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));

        int last=arr[0][1];
        int count=1;
int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i][0]>=last){
                count++;
                last=arr[i][1];
            }
        }
        return n-count;
        
    }
}