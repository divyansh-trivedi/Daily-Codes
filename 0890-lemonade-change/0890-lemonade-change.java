class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a=0,b=0,c=0;
boolean flag=true;
if(bills[0]>5)return false;
 
 

        for(int i=0;i<bills.length;i++){
         

           if(bills[i]==5){
            a++;
            
           } 
           else if(bills[i]==10){

            if(a==0)
            return false;

            a--;
            b++;
           }
           else{
            
            
             if(a>=1&&b>=1 ){
                a--;
                b--;
              
            }else if(a>=3 ){
            a=a-3;
           
            }
            else{
            return false;

            }
           }

        }

        return true;
        
    }
}