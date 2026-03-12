package leetCodeProblems;

class SearchMatrix {
    public boolean searchMatrixx(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        
        // Treat as 1D sorted array of size m*n
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	SearchMatrix s = new SearchMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(s.searchMatrixx(matrix, 3));  // true
        System.out.println(s.searchMatrixx(matrix, 13)); // false
    }

}

