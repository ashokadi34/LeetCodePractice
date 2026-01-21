package leetCodeProblems;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int curRow = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
    
    //test cases
    public static void main(String[] args) {
        ZigzagConversion sol = new ZigzagConversion();
        
        // Example 1
        System.out.println("Example 1: " + sol.convert("PAYPALISHIRING", 3));  // "PAHNAPLSIIGYIR"
        
        // Example 2
        System.out.println("Example 2: " + sol.convert("PAYPALISHIRING", 4));  // "PINALSIGYAHRPI"
        
        // Example 3
        System.out.println("Example 3: " + sol.convert("A", 1));                // "A"
    }
}

