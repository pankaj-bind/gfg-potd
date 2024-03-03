class Solution {
    String printLargest(int n, String[] arr) {
        // Custom comparator to compare two strings based on their concatenation
        Comparator<String> customComparator = (s1, s2) -> (s2 + s1).compareTo(s1 + s2);

        // Sort the array of strings using the custom comparator
        Arrays.sort(arr, customComparator);

        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}