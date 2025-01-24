import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> safeNodes = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) {
                safeNodes.add(i);
            }
        }

        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (!safeNodes.contains(i)) {
                    boolean isSafe = true;
                    for (int neighbor : graph[i]) {
                        if (!safeNodes.contains(neighbor)) {
                            isSafe = false;
                            break;
                        }
                    }
                    if (isSafe) {
                        safeNodes.add(i);
                        changed = true;
                    }
                }
            }
        } while (changed);

        result.addAll(safeNodes);
        Collections.sort(result);
        return result;
    }
}
