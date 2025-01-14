class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int ar[] = new int[A.length];
        for(int i=1;i<= A.length;i++){
            set.add(A[i-1]);
            set.add(B[i-1]);

            ar[i-1]=2*i - set.size();

        }
        return ar;
    }
}