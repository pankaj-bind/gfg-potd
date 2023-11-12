class Solution
{
    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Concatenate the first two characters at the end
        String clockwiseRotation = str1.substring(2) + str1.substring(0, 2);

        // Concatenate the last two characters at the beginning
        String anticlockwiseRotation = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);

        // Check if either rotation is equal to the target string
        return str2.equals(clockwiseRotation) || str2.equals(anticlockwiseRotation);
    }
}