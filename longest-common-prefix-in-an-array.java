// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }

        return prefix;
    }
}
