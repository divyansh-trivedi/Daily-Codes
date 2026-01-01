class Solution {
    public int[] plusOne(int[] digits) {
        int flag=0;
        
       
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1>9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                flag=1;
                break;
            }
        }
        int ar[]=new int [digits.length+1];
        ar[0]=1;
        int m=1;
        if(flag==1)
            return digits;
        
        else{
            for(int i:digits)
                ar[m++]=i;
           
        }
         return ar;
    }
}
