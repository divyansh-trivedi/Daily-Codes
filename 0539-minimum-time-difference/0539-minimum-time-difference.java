class Solution {
    public int findMinDifference(List<String> timepoints) {
        int [] times= new int[timepoints.size()];

        for(int i=0;i<times.length;i++){
           String str=timepoints.get(i);
           int hr=Integer.parseInt(str.substring(0,2));
           int min=Integer.parseInt(str.substring(3));
           times[i]=hr*60 + min;
        }
        Arrays.sort(times);
        int min=(int)1e9;
      for(int i=1;i<times.length;i++){
int k=Math.abs(times[i]-times[i-1]);
min=Math.min(min,k);
      }     

      // handling wrap around case
      int wrap=1440-times[times.length-1]+times[0];
      return min=Math.min(wrap,min);
    }
}