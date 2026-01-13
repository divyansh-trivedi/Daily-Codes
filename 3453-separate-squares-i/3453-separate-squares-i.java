class Solution {
    public double separateSquares(int[][] squares) {
        List<double[]> events = new ArrayList<>();
        double totalArea = 0;
        
        for (int[] square : squares) {
            int x = square[0];
            int y = square[1];
            int l = square[2];
            
            events.add(new double[]{y, l});
            events.add(new double[]{y + l, -l});
            
            totalArea += (long)l * l;
        }
        
        Collections.sort(events, (a, b) -> Double.compare(a[0], b[0]));
        
        double targetArea = totalArea / 2;
        double areaBelow = 0;
        double rateOfChange = 0;
        double prevY = events.get(0)[0];
        
        for (double[] event : events) {
            
            double y = event[0];
            double deltaRate = event[1];
            
            areaBelow += rateOfChange * (y - prevY);
            
            if (areaBelow >= targetArea && rateOfChange > 0) {
                double extraArea = areaBelow - targetArea;
                double distanceBack = extraArea / rateOfChange;
                return y - distanceBack;
            }
            
            rateOfChange += deltaRate;
            prevY = y;
        }
        
        return -1;
    }
}