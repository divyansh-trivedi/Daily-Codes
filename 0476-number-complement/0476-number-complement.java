//LC POTD 

class Solution {
    public int findComplement(int num) {
     int digits=(int)(Math.log(num)/Math.log(2))+1;
		int ans=num ^ ((1 << digits) -1);
  return ans; 
    }
}