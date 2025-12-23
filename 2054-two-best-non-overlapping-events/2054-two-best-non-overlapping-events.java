class Solution {
    public int maxTwoEvents(int[][] events) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0, temp = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                temp = Math.max(temp, pq.peek()[1]);
                pq.poll();
            }
            res = Math.max(res, temp + event[2]);
            pq.add(new int[] { event[1], event[2] });
        }

        return res;
    }
}