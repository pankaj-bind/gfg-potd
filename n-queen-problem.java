class Solution {
    
    // Function to check if it's safe to place a queen at board[row][col]
    private boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < col; i++) {
            // Check if there's a queen in the same row
            if (board[i] == row) return false;
            
            // Check if there's a queen in the same diagonal
            if (Math.abs(board[i] - row) == Math.abs(i - col)) return false;
        }
        return true;
    }
    
    // Backtracking function to solve the N-Queen problem
    private void solveNQueens(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1);  // +1 because 1-based indexing is used in the output
            }
            result.add(solution);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;
                solveNQueens(col + 1, n, board, result);
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        
        // Start solving with the first column
        solveNQueens(0, n, board, result);
        
        return result;
    }
}
