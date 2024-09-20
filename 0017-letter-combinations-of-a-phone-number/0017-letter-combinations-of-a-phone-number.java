class Solution {
       ArrayList<String> ar= new ArrayList<>();
    
    public void solve(String str[], int idx, String digits, String ans){
        // base case to write 
        if(idx==digits.length()){
ar.add(ans);
return;
        }
        String tele=str[Character.getNumericValue(digits.charAt(idx))];
        for(int i=0;i<tele.length();i++){
          solve(str,idx+1,digits,ans+tele.charAt(i))  ;
        }
    }
    public List<String> letterCombinations(String digits) {
        String str[]= {"", "","abc", "def", "ghi", "jkl", "mno" ,"pqrs", "tuv", "wxyz" };
if(digits.length()==0)return ar;
        solve(str,0,digits,"");
        return ar;

    }
}