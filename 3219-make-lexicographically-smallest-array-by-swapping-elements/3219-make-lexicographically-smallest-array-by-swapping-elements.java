class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);

        int currGroup = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, Queue<Integer>> groupToList = new HashMap<>();

        numToGroup.put(numsSorted[0], currGroup);
        groupToList.putIfAbsent(currGroup, new LinkedList<>());
        groupToList.get(currGroup).offer(numsSorted[0]);

        for (int i = 1; i < n; i++) {
            if (numsSorted[i] - numsSorted[i - 1] > limit) {
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            groupToList.putIfAbsent(currGroup, new LinkedList<>());
            groupToList.get(currGroup).offer(numsSorted[i]);
        }

        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            nums[i] = groupToList.get(group).poll(); 
        }

        return nums;
    }
}