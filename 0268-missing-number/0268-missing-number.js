/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let n = nums.length;
    let totalSum = (n*(n+1))/2;
    let sum =0;
    for(const it of nums)
    sum += it;

    return totalSum -sum;
};