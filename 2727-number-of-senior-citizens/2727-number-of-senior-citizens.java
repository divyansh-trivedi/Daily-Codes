class Solution {
    public int countSeniors(String[] details) {
        int c=0;
        for(int i=0;i<details.length;i++){
        //    int a=(int)details[i].charAt(11);
        //    int b=(int)details[i].charAt(12);

        //    int age=(a*10)+b;
        String k=details[i];
        k=k.substring(11,13);
        int age=Integer.parseInt(k);
           if(age>60)c++;
        }
        return c;
    }
}