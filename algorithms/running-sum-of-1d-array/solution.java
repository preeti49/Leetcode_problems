import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(0, n, board, result);
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> result) {
        // Base case: If we successfully placed queens in all rows, add the configuration
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        
        // Try placing a queen in each column for the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q'; // Place queen
                backtrack(row + 1, n, board, result); // Recurse to next row
                board[row][col] = '.'; // Backtrack (remove queen)
            }
        }
    }
    
    private boolean isSafe(int row, int col, int n, char[][] board) {
        // 1. Check column upward
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // 2. Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // 3. Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}