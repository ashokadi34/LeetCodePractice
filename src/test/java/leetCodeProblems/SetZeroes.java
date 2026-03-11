package leetCodeProblems;

class SetZeroes {
    public void setZero(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false, col0 = false;
        
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) row0 = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) col0 = true;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = m - 1; i >= 1; i--) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) matrix[i][j] = 0;
            }
        }
        for (int j = n - 1; j >= 1; j--) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) matrix[i][j] = 0;
            }
        }
        
        if (row0) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (col0) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
    
    // Local testing + print util
    public static void main(String[] args) {
    	SetZeroes sol = new SetZeroes();
        
        // Test 1
        int[][] m1 = {{1,1,1},{1,0,1},{1,1,1}};
        sol.setZero(m1);
        printMatrix(m1);
        
        // Test 2  
        int[][] m2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        sol.setZero(m2);
        printMatrix(m2);
    }
    
    static void printMatrix(int[][] matrix) {
        System.out.println("Result:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

