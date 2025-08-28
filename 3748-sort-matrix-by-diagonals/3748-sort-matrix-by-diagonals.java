class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int idx=i-j;
                if(map.containsKey(idx))
                {
                    List<Integer> l=map.get(idx);
                    l.add(grid[i][j]);
                    map.put(idx,l);
                }
                else
                {
                    List<Integer> l=new ArrayList<Integer>();
                    l.add(grid[i][j]);
                    map.put(idx,l);
                }
            }
        }
        ArrayList<Integer> d=new ArrayList<Integer>(map.keySet());
        for(int idx:d)
        {
                if(idx<0) Collections.sort(map.get(idx));
                else
                {
                    Collections.sort(map.get(idx),Collections.reverseOrder());
                }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=map.get(i-j).get(0);
                List<Integer> l=map.get(i-j);
                l.remove(0);
                map.put(i-j,l);
            }
        }
        return grid;


    }
}