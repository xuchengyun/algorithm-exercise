/*
Sudoku
数独
*/

// 高频题
class Solution {
    // soluiton 1:
    // use three hashSets
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            // 3 hashsets
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}