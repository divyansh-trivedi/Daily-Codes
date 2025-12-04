class Solution {
private:
    bool isPossible(int n, vector<int>& batteries, long long mid_min){
        long long target_min = n*mid_min;
        long long sum = 0;
        for(int i: batteries){
            sum += min((long long)i, mid_min);
            if(sum >= target_min)return true;
        }
        return false;
    }
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        long long i = *min_element(batteries.begin(), batteries.end());
        long long j = (accumulate(batteries.begin(), batteries.end(),0LL))/n;
        long long ans = 0;
        while(i <= j){
            long long mid_min = i + (j-i)/2;
            if(isPossible(n, batteries, mid_min)){
                ans = mid_min;
                i = mid_min+1;
            }else j = mid_min-1;
        }
        return ans;
    }
};
/* n computers
ith - > batteries[i]

Input: n = 2, batteries = [3,3,3]
Output: 4

 [3,3,3]
 [3,3,3] -> for first second computer battery
 after 2min 
 [1,1,3]->[1,3,1]
 after 1 min
 [0,2,1] -> [1,2,0]
 after 1 min
 [0,1,0] -> now both can't run
ans = 4 ;'

Input: n = 2, batteries = [1,1,1,1]
Output: 2
[1,1,1,1]
afteer 1 min
[1,1,0,0]
after 1 min all zero hence 2 mins

Let's take input-:'
n = 3 batteries = [4, 3,2,1,5]
sort -> allot max to the number of batteries
[5,4,3,2,1]-> alloted 5,4,3 to n = 3
after 3 mins
[2,1,0,2,1]-> [2,2,2,0,0] 
after 2 all zero ans = 5 

n=3 [4,1,5,1,3,6,2] => [6,5,4,3,2,1,1] => extra 7 for[6, 5, 4] => [6, 5, 5] => 6 remains => [6, 5, 6] => 5 remains

=> lets try binary search
For Input: n = 2, batteries = [3,3,3]
Output: 4
i = 3, j = 9/3 = 3+1 =4
then do binary search
For n=3 [4,1,5,1,3,6,2] => [6,5,4,3,2,1,1] 
i = 1 ; j = 22/3 = 7+1 = 8;
mid = 4;
for n = 
 */
