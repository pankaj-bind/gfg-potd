// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        double low = 0.0;
        double high = stations[n - 1] - stations[0];
        
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (canPlaceStations(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return Math.round(high * 100.0) / 100.0;
    }
    
    private static boolean canPlaceStations(int[] stations, int k, double maxDist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            double distance = stations[i] - stations[i - 1];
            count += (int) (distance / maxDist);
        }
        return count <= k;
    }
}
