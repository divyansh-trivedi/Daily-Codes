import java.util.Arrays;  

class Solution {  
    public int findLengthOfShortestSubarray(int[] arr) {  
        int n = arr.length;  
        int left = 0;  
        int right = n - 1;  
        while (left + 1 < n && arr[left] <= arr[left + 1])  left++;

        if (left == n - 1) return 0; 

        while (right - 1 >= left && arr[right] >= arr[right - 1])    right--;  
          

        int ans = Math.max(n - right, left + 1);  
        int i = 0, j = right;  
        while (i <= left && j < n) {  
            if (arr[i] <= arr[j]) {  
                ans = Math.max(ans, i + 1 + (n - j));  
                i++;  
            } else 
                j++; 
        }  
    return n - ans;  
    }  
}