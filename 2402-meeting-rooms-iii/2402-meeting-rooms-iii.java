class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> f = new PriorityQueue<>();
        for (int i = 0; i < n; ++i)
            f.offer(i);
        PriorityQueue<long[]> arr = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1])
                : Long.compare(a[0], b[0]));
        int[] c = new int[n];
        for (int[] m : meetings) {
            long s = m[0], end = m[1];
            while (!arr.isEmpty() && arr.peek()[0] <= s)
                f.offer((int) arr.poll()[1]);
            int r;
            long ne;
            if (!f.isEmpty()) {
                r = f.poll();
                ne = end;
            } else {
                long[] e = arr.poll();
                r = (int) e[1];
                ne = e[0] + (end - s);
            }
            arr.offer(new long[] { ne, r });
            c[r]++;
        }
        int ans = 0;
        for (int i = 1; i < n; ++i)
            if (c[i] > c[ans])
                ans = i;
        return ans;
    }
}
