class Solution {
    const int static mod = 1e9+7;
public:
    int numSub(string s) {
        int n = s.size();

        long long cnt =0;
        long long sum =0;
        for(int i=0;i<n;i++){
            if(s[i] == '0')cnt = 0;
            else{
                cnt++;
                sum += cnt;
            }
        }
        return (int)(sum%mod);
    }
};

/* 
s = "0110111"
        i   j
0 1 2 2 3 4 5

sum = 8

"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.

 s = "111111" 
1 2 3 4 5 6
 1       ->6
 11      ->5
 111     ->4
 1111    ->3
 11111   ->2
 111111  ->1


s = "0110111"
cnt = 1 2 0 1 2 3
sum = 3 
 

 brute force ->
 o(n^3) -> for substring
 o(n^2) -> for substring

  */