class Solution {
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<String> seenRows = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringBuilder rowStringBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                rowStringBuilder.append(matrix[i][j]);
            }

            String rowString = rowStringBuilder.toString();

            if (seenRows.contains(rowString)) {
                // This row is a duplicate
                result.add(i);
            } else {
                seenRows.add(rowString);
            }
        }

        return result;
    }
}