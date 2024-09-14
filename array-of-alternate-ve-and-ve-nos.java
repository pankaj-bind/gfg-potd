class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        
        arr.clear(); // Clear the original array to fill with rearranged elements
        int posIndex = 0, negIndex = 0;
        
        // Alternate adding positive and negative numbers
        while (posIndex < positive.size() && negIndex < negative.size()) {
            arr.add(positive.get(posIndex++));
            arr.add(negative.get(negIndex++));
        }
        
        // If there are remaining positive numbers
        while (posIndex < positive.size()) {
            arr.add(positive.get(posIndex++));
        }
        
        // If there are remaining negative numbers
        while (negIndex < negative.size()) {
            arr.add(negative.get(negIndex++));
        }
    }
}
