class Solution {
    class Pair {
        int from, to;
        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            } else if(o == null || this.getClass() != o.getClass()) {
                return false;
            } else {
                Pair p = (Pair) o;
                return ((this.from == p.from) && (this.to == p.to));
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.from, this.to);
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        HashMap<Pair,Boolean> hMap = new HashMap<>();

        List<Boolean> res = new ArrayList<>();

        for(int i=0; i<queries.length; i++) {
            if(dfs(queries[i][0], queries[i][1], adj, hMap)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public boolean dfs(int curr, int target, List<List<Integer>> adj, HashMap<Pair,Boolean> hMap) {
        Pair currPair = new Pair(curr, target);
        if(hMap.containsKey(currPair)) {
            return hMap.get(currPair);
        }

        for(int neighbor : adj.get(curr)) {
            if((neighbor == target) || dfs(neighbor, target, adj, hMap)) {
                hMap.put(currPair, true);
                return true;
            }
        }

        hMap.put(currPair, false);
        return false;
    }
}