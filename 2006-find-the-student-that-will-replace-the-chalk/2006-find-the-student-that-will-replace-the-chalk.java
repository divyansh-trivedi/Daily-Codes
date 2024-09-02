class Solution {
    public int chalkReplacer(int[] chalk, int k1) {
        long sum = 0;
        long k=(long)k1;
        for (int i = 0; i < chalk.length; i++)
            sum += chalk[i];

            k=(int)k%sum;
int idx=-1;
            for(int i=0;i<chalk.length;i++){
                 k=k-chalk[i];
                if(k<0){
                    idx=i;
                    break;
                }
               
            }

         return idx;
    }
}