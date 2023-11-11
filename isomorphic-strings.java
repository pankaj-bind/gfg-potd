class Solution
{
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2)
    {
        // If lengths are different, they can't be isomorphic.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create two HashMaps to store mappings.
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        // Iterate through each character of both strings.
        for (int i = 0; i < str1.length(); i++)
        {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // If the mapping is already present, check if it is consistent.
            if (map1.containsKey(char1))
            {
                if (map1.get(char1) != char2) {
                    return false;
                }
            }
            else
            {
                // If the mapping is not present, create a new mapping.
                map1.put(char1, char2);
            }

            // Repeat the process for the reverse mapping.
            if (map2.containsKey(char2))
            {
                if (map2.get(char2) != char1) {
                    return false;
                }
            }
            else
            {
                map2.put(char2, char1);
            }
        }

        // If the loop completes without returning false, the strings are isomorphic.
        return true;
    }
}