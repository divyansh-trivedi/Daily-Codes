class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
     
        Arrays.sort(nums);
        for (int i = 0; i < n-3; i++) {
         
            for (int j = i + 1; j < n-2; j++) {
               
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                   if (sum == target) {
                       set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // while (k < l && nums[k] == nums[k - 1]) {
                        //     k++; // Skip duplicate values
                        // }
                        // while (k < l && nums[l] == nums[l - 1]) {
                        //     l--; // Skip duplicate values
                        // }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }
        list.addAll(set);
       
        return list;

    }
}