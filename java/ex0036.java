import java.util.*;

class ex0036{
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