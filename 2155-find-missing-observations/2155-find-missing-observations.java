class Solution {
   
    public int[] missingRolls(int[] rolls, int mean, int n) {
         int sum = 0;int m=rolls.length;
        for (int roll : rolls) {
            sum += roll;
        }
       int remaining=mean*(n+m);
       remaining=(remaining-sum);
       int quotient=remaining/n;
       int remainder=remaining%n;

       if(remaining>6*n||n==0 || remaining<n)return new int[]{};

        int ar[]= new int[n];

        for(int i=0;i<n;i++)ar[i]=quotient;

        for(int i=0;i<remainder;i++)ar[i]++;
return ar;
        
        
    }
}