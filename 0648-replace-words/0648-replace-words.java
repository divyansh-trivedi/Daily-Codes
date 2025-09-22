class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       String [] arr = sentence.split(" ");
        for(int i=0;i<dictionary.size();i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j].startsWith(dictionary.get(i))){
                    arr[j] = dictionary.get(i);
                }
            }
        }

       String s = String.join(" ",arr);
       return s;
    }
}