func countPalindromicSubsequence(s string) int {
    n := len(s)
    first := make([]int, 26)
    last  := make([]int, 26)
     
    for i := 0; i<26 ;i++{
        first[i] = -1; 
        last[i] = -1; 
    }

    for i := 0; i<n; i++{
        c := int(s[i]-'a')
        if first[c] == -1{
            first[c] = i;
        }
        last[c] = i;
    }

    cnt := 0
    for i := 0; i< 26; i++{
        if first[i] == -1 || last[i] - first[i] < 2 {
            continue
        }
        freq := make([]int, 26)
        l := first[i]+1;
        r := last[i]-1;
        for j := l; j<=r; j++{
            curr := int(s[j]-'a')
            freq[curr] = 1;
        }
        sum := 0
        for j := 0; j<26; j++{
            sum += freq[j]
        }
        cnt +=  sum
    }
    return cnt
}

// first in GO