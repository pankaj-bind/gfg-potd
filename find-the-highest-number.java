class Solution {
    public int findPeakElement(List<Integer> a) {
        int left = 0;
        int right = a.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a.get(mid) > a.get(mid + 1)) {
                // Peak is in the left half including mid
                right = mid;
            } else {
                // Peak is in the right half excluding mid
                left = mid + 1;
            }
        }
        // left and right will converge to the peak element
        return a.get(left);
    }
}