class Solution {
public:
    int maxOperations(string s) {
        int one  = 0;
        int cnt = 0;
        for(int i=0;i<s.size();){
            if(s[i] == '1'){
                one++;
                i++;
            }
            else{
                cnt += one;
                while(s[i] == '0')i++;  
            }
        }
        return cnt;
    }
};

/* 
"100101010"-:
[1,2,3,4]
001101010 
001011010
000111010
000110110
000101110
000011110
000011101
000011011
000010111
000001111

"1001101"-:[1,3]
0011101
0011011
0010111
0001111

1001101
one = 0, cnt = 0;
i=0-> one =1, cnt =0;
i=1-> one =1, cnt =1;

 */