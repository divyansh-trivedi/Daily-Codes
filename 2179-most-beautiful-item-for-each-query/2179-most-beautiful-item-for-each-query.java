class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int []result= new int [queries.length];
        int []prices = new int [items.length];
        int[] max= new int[items.length +1];
        Arrays.sort(items,(a,b) -> Integer.compare(a[0],b[0]));

        for (int i=0;i<items.length;i++){
            max[i+1]=Math.max(max[i],items[i][1]);

        }
        for (int i=0;i<queries.length;i++){
            int a= binarySearch(items,queries[i]);
            result[i]=max[a];
        }
        return result;
    }

    private int binarySearch(int[][] items, int b) {
    int l = 0;
    int r = items.length;
    while (l < r) {
      final int mid = (l + r) / 2;
      if (items[mid][0] > b)
        r = mid;
      else
        l = mid+ 1;
    }
    return l;
  }
}