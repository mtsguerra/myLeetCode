class ex0036{
    /**
     * Determine if a 9x9 Sudoku board is valid.
     *
     * A Sudoku board is valid if:
     * - Each row contains the digits 1-9 without repetition.
     * - Each column contains the digits 1-9 without repetition.
     * - Each of the nine 3x3 sub-boxes contains the digits 1-9 without repetition.
     *
     * Time Complexity: O(n^2), where n is the size of the board (9x9).
     * Space Complexity: O(n), for the boolean arrays used to track seen numbers.
     *
     * @param board a 2D character array representing the Sudoku board
     * @return true if the board is valid, false otherwise
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] cols = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] subSquares = new boolean[9][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.' ) continue;
                int square = (i / 3) * 3 + (j / 3);
                int current = board[i][j] - '1';
                if (cols[j][current]
                    || rows[i][current]
                    || subSquares[square][current]) return false;
                cols[j][current] = true;
                rows[i][current] = true;
                subSquares[square][current] = true;
            }
        }
        return true;
    }
}