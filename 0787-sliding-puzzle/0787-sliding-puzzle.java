class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        StringBuilder str = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++)
                str.append(board[i][j]);
        }

        String start = str.toString();

        if(start.equals(target))return 0;

        int moves[][] = {
            {1,3},    //0
            {0,2,4},   //1
            {1,5},     //2
            {0,4},      //3
            {1,3,5},     //4
            {2,4}       //5
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int count=0;//steps

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i< size;i++){
                String current = queue.poll();
                int zero_idx= current.indexOf('0');

                for(int move : moves[zero_idx] ){
                    String next = swap(current , zero_idx, move);

                    if(next.equals(target))return count+1;

                    if(!visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }

                }
            }
            count++;
        }
        return -1;
    }

    private String swap(String s , int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}