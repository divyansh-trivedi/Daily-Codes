import java.util.*;

class Solution {
    private int[] findPSE(int arr[]) {
        int n = arr.length;
        int ar[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()])
                st.pop();

            if (!st.isEmpty())
                ar[i] = st.peek();
            else
                ar[i] = -1;

            st.push(i);
        }

        return ar;
    }

    public int[] findNSE(int arr[]) {
        int n = arr.length;
        int ar[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()])
                st.pop();

            if (!st.isEmpty())
                ar[i] = st.peek();
            else
                ar[i] = n;

            st.push(i);
        }
        return ar;

    }

    public int largestRectangleArea(int[] heights) {
        int nse[] = findNSE(heights);
        int pse[] = findPSE(heights);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            max = Math.max(max, area);
        }
        return max;
    }
}