import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
            }
            outdegree[i] = graph[i].length;
            if (outdegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int prev : reverseGraph.get(node)) {
                if (--outdegree[prev] == 0) queue.add(prev);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
