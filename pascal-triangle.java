import java.util.ArrayList;

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // Code to generate Pascal's Triangle up to N rows
        ArrayList<ArrayList<Long>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1L);
                } else {
                    // Sum of the two elements above in the previous row
                    long val = (triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j)) % 1000000007;
                    row.add(val);
                }
            }
            triangle.add(row);
        }

        // Return the Nth row
        return triangle.get(n - 1);
    }
}
