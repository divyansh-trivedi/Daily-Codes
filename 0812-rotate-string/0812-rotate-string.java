class Solution {
    public boolean rotateString(String s, String goal) {

        String res="";
        for(int i=0;i<goal.length();i++){
            res=   goal.substring(i,goal.length())+ goal.substring(0,i);
            if(res.equals(s))
             return true;
        }
        return false;
    }
}