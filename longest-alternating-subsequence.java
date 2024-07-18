class Solution {
    public int alternatingMaxLength(int[] arr) {
        if (arr.length == 0) return 0;
        
        int up = 1, down = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }
        
        return Math.max(up, down);
    }
}
