class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ar[]= new int[grid.length*grid[0].length];
  for(int i=0;i<grid.length;i++){
    for(int j=0;j<grid[0].length;j++){
        ar[grid[i][j]-1]++;

    }
  }
  int missing=-1, repeated=-1;


  for(int i=0;i<grid.length*grid[0].length;i++ ){
   if(ar[i]==0)
   missing=i+1;
   if(ar[i]==2)
   repeated=i+1;

   if(repeated!=-1&&missing!=-1)
   break;
  }
  return new int[]{repeated, missing};

    }

}