class Solution {
    Map<Params, int[]> map = new HashMap<>();;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        Params params = new Params(n, firstPlayer, secondPlayer);
        if (map.containsKey(params)) {
            return map.get(params);
        }
        int[] splits = new int[] {
            firstPlayer, secondPlayer, n - firstPlayer + 1, n - secondPlayer + 1
        };
        if (splits[0] == splits[3]) {
            return new int[] {1, 1};
        }
        splits = Arrays.stream(splits).distinct().toArray();
        Arrays.sort(splits);
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE / 2;
        for (int group1 = 0; group1 < splits[0]; group1++) {
            for (int group2 = 0; group2 < splits[1] - splits[0]; group2++) {
                int[] groups;
                if (splits.length == 4) {
                    groups = new int[] {
                        group1, group2, (splits[2] - splits[1]) / 2, splits[1] - splits[0] - 1 - group2
                    };
                } else {
                    groups = new int[] {
                        group1, group2, splits[1] - splits[0] - 1 - group2
                    };
                }
                int prefSum = 0, newFirst = 0, newSecond = 0;
                for (int i = 0; i < splits.length; i++) {
                    prefSum += groups[i];
                    if (splits[i] == firstPlayer) {
                        newFirst = prefSum + 1;
                        prefSum++;
                    } else if (splits[i] == secondPlayer) {
                        newSecond = prefSum + 1;
                        break;
                    }
                }
                int[] curr = earliestAndLatest((n + 1) / 2, newFirst, newSecond);
                res[0] = Math.min(res[0], curr[0] + 1);
                res[1] = Math.max(res[1], curr[1] + 1);
            }
        }
        map.put(params, res);
        return res;
    }

    record Params(int n, int firstPlayer, int secondPlayer) {}
}