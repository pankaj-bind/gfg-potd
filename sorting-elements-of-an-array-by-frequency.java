
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Step 1: Create a HashMap to store the frequency of each element.
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of the array elements for custom sorting.
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Step 3: Sort the list based on frequency and value.
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqCompare = freqMap.get(b) - freqMap.get(a); // Compare by frequency
                if (freqCompare == 0) {
                    return a - b; // If frequencies are the same, sort by the element value
                }
                return freqCompare; // Otherwise, sort by frequency
            }
        });

        return list;
    }
}
