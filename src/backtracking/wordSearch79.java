package backtracking;

public class wordSearch79 {
    int m, n;


    /*
    /*Space Complexity: O(L)
Time Complexity: O(M * N * 3^L)
Space Complexity is because of recursion - to store function stack context.
Time Complexity - from every block we go in three adjacent blocks (avoiding the direction we came from).
This walk can go for max of L times. So each thred at most goes L length long. -> O(3^L).
Now this is applied at each node from main calling function -> O(M * N). Therefore, O(M * N * 3^L).
*/

    public boolean find(char[][] board, int i, int j, int idx, String word) {

        // base case: entire word matched
        if (idx == word.length())
            return true;

        // boundary + visited + mismatch check
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$'
                || board[i][j] != word.charAt(idx))
            return false;

        // mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '$';

        // explore all 4 directions
        boolean found =
                find(board, i + 1, j, idx + 1, word) ||
                        find(board, i - 1, j, idx + 1, word) ||
                        find(board, i, j + 1, idx + 1, word) ||
                        find(board, i, j - 1, idx + 1, word);

        // backtrack (restore original value)
        board[i][j] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) &&
                        find(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
}
