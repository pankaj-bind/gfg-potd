import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}

class Solution {
    public int romanToDecimal(String str) {
        // Create a HashMap to store Roman numeral values
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        // Initialize result to store the final integer value
        int result = 0;

        // Iterate through the Roman numeral string
        for (int i = 0; i < str.length(); i++) {
            int currentValue = romanValues.get(str.charAt(i));

            // If current symbol is smaller than the next symbol, subtract it
            if (i + 1 < str.length() && romanValues.get(str.charAt(i + 1)) > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }
}
