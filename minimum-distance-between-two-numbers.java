class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minDistance = Integer.MAX_VALUE;
        int lastSeenX = -1;
        int lastSeenY = -1;
        
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                if (lastSeenY != -1) {
                    minDistance = Math.min(minDistance, i - lastSeenY);
                }
                lastSeenX = i;
            } else if (a[i] == y) {
                if (lastSeenX != -1) {
                    minDistance = Math.min(minDistance, i - lastSeenX);
                }
                lastSeenY = i;
            }
        }
        
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
