package Arrays.Array2D;

public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0 = false, col0 = false;

        // check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) row0 = true;
        }

        // check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = true;
        }

        // use first row & column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // zero rows based on markers
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // zero columns based on markers
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // handle first row
        if (row0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // handle first column
        if (col0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
