/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let zero = 0;
    let sum = 1;

    for(const it of nums){ 
        if(it !=0)sum *= it;
        else zero++;
    }

    let arr = [];

    for(const it of nums){
        if(zero >= 2)arr.push(0);
        else if(zero == 1 && it == 0)arr.push(sum);
        else if(zero == 1)arr.push(0);
        else arr.push(sum/it);
    }
    return arr;

};