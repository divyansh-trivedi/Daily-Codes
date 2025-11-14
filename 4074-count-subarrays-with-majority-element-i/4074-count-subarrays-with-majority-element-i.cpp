class Solution {
public:
    int countMajoritySubarrays(vector<int>& nums, int target) {
        int n = nums.size();
        int sum = 0;
        for(int i =0;i<n;i++){
            int c =0;
            for(int j=i;j<n;j++){
                 c += (nums[j] == target) ? 1 : -1;
                 if(c > 0) sum++;
            }
        }
        return sum;
    }
};
/* 
1 1 2 2 1 1 2 2 3 3 

4 -> 2
2 -> 2,2
2 -> 1,2,2 | 2,2,1
1 -> 1,2,2
1-> 2,2,3
1->2 2 1 1 2
1->2 1 1 2 2
1->1 2 2 1 1 2 2 
1->2 2 1 1 2 2 3
1->2 2 1 1 2 2 3 3

target = 2
1 1 2 2 1 1 2 2 3 3
-1 -2 -1 0 -1 -2 -1 0 -1 -2 ->  sum =0;

1 2 2 1 1 2 2 3 3
-1 0 1 0 -1 0 1 0 -1 -> sum = 1+1 =2

2 2 1 1 2 2 3 3
1 2 1 0 1 2 1 0 -> sum = 2+6 = 8

2 1 1 2 2 3 3
1 0 -1 0 1 0 -1 -> sum = 8 + 2 = 10;

1 1 2 2 3 3
-1 -2 -1 0 -1 -2 -> sum = 10;

1 2 2 3 3
-1 0 1 0 -1 -> sum = 10 +1 =11

2 2 3 3
1 2 1 0 -> sum = 11+3 = 14;

2 3 3
1 0 -1 -> sum = 14+1 =15;

3 3 -> nothing */