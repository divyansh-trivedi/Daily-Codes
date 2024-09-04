class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
      Set<String> list=new HashSet<>();

      for(int i[]:obstacles){
        String s=i[0]+"_"+i[1];
        list.add(s);
      }

    int x=0;
    int y=1;

int x1=0,y1=0;
    int max=Integer.MIN_VALUE;

      for(int i:commands){
        if(i==-1){
            int k=y;
            y=-x;
            x=k;
        }
        else if(i==-2){
            int k=-y;
            y=x;
            x=k;
        }
        else {
            while(i-->0){
                int newx=x1+x;
                int newy=y1+y;

                 String s = newx + "_" + newy;

                if(list.contains(s))
                break;

                x1=newx;
                y1=newy;




            }
        }
          max=Math.max(max,x1*x1+y1*y1);
      }
    
      return max;
         }
         
}
