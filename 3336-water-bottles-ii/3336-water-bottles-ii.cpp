class Solution {
public:
    int maxBottlesDrunk(int full, int ne) {
        int empty = full;
        int sum = full;
        full = 0;
        while(empty >= ne){
            empty -= ne;
            full = 1;
            ne++;
            sum += full;
            empty += full;
            full = 0;
        }
        return sum;
    }
};
