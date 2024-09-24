class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";
        }

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char ch : p.toCharArray()) {
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        int start = 0, minLen = Integer.MAX_VALUE, startIdx = -1;
        int count = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            windowFreq.put(endChar, windowFreq.getOrDefault(endChar, 0) + 1);

            if (targetFreq.containsKey(endChar) && windowFreq.get(endChar) <= targetFreq.get(endChar)) {
                count++;
            }

            while (count == p.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIdx = start;
                }

                char startChar = s.charAt(start);
                windowFreq.put(startChar, windowFreq.get(startChar) - 1);

                if (targetFreq.containsKey(startChar) && windowFreq.get(startChar) < targetFreq.get(startChar)) {
                    count--;
                }

                start++;
            }
        }

        return startIdx == -1 ? "-1" : s.substring(startIdx, startIdx + minLen);
    }
}
