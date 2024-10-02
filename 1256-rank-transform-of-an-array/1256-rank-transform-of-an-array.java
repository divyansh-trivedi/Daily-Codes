class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        
        int brr[]=arr.clone();
        Arrays.sort(brr);
        int kk=1;
        for(int i=0;i<brr.length;i++){
            if(!map.containsKey(brr[i]))
        map.put(brr[i],kk++);

        }

        for(int i=0;i<arr.length;i++){
            int k=map.get(arr[i]);
            arr[i]=k;
        }
        return arr;
    }
}