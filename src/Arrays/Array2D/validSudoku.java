package Arrays.Array2D;

import java.util.HashSet;

public class validSudoku {

    private boolean validSub(char[][] board, int sr, int er, int sc, int ec) {
        HashSet<Character> set = new HashSet<>();

        for (int row = sr; row <= er; row++) {
            for (int col = sc; col <= ec; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;

                if (set.contains(ch)) return false;
                set.add(ch);
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {

        // validate rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;

                if (set.contains(ch)) return false;
                set.add(ch);
            }
        }

        // validate columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch == '.') continue;

                if (set.contains(ch)) return false;
                set.add(ch);
            }
        }

        // validate each 3×3 box
        for (int sr = 0; sr < 9; sr += 3) {
            int er = sr + 2;
            for (int sc = 0; sc < 9; sc += 3) {
                int ec = sc + 2;
                if (!validSub(board, sr, er, sc, ec)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char ch = board[row][col];
                if (ch == '.') continue;

                int num = ch - '1'; // 0 to 8
                int box = (row / 3) * 3 + (col / 3);

                if (rows[row][num] || cols[col][num] || boxes[box][num]) {
                    return false;
                }

                rows[row][num] = true;
                cols[col][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }
}
