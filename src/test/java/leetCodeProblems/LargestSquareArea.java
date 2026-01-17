package leetCodeProblems;

public class LargestSquareArea {
    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;
        int n = bottomLeft.length;
        
        for (int i = 0; i < n; i++) {
            int x1 = bottomLeft[i][0];
            int y1 = bottomLeft[i][1];
            int x2 = topRight[i][0];
            int y2 = topRight[i][1];
            
            for (int j = i + 1; j < n; j++) {
                int x3 = bottomLeft[j][0];
                int y3 = bottomLeft[j][1];
                int x4 = topRight[j][0];
                int y4 = topRight[j][1];
                
                // Intersection rectangle coordinates
                int interLeft = Math.max(x1, x3);
                int interBottom = Math.max(y1, y3);
                int interRight = Math.min(x2, x4);
                int interTop = Math.min(y2, y4);
                
                // Width and height of intersection
                int width = interRight - interLeft;
                int height = interTop - interBottom;
                
                if (width > 0 && height > 0) {
                    int side = Math.min(width, height);
                    long area = (long) side * side;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[][] bottomLeft1 = {{1,1},{2,2},{3,1}};
        int[][] topRight1 = {{3,3},{4,4},{6,6}};
        System.out.println("Example 1: " + largestSquareArea(bottomLeft1, topRight1));  // Expected: 1
        
        // Example 2
        int[][] bottomLeft2 = {{1,1},{1,3},{1,5}};
        int[][] topRight2 = {{5,5},{5,7},{5,9}};
        System.out.println("Example 2: " + largestSquareArea(bottomLeft2, topRight2));  // Expected: 4
        
        // Example 3
        int[][] bottomLeft3 = {{1,1},{2,2},{1,2}};
        int[][] topRight3 = {{3,3},{4,4},{3,4}};
        System.out.println("Example 3: " + largestSquareArea(bottomLeft3, topRight3));  // Expected: 1
        
        // Example 4
        int[][] bottomLeft4 = {{1,1},{3,3},{3,1}};
        int[][] topRight4 = {{2,2},{4,4},{4,2}};
        System.out.println("Example 4: " + largestSquareArea(bottomLeft4, topRight4));  // Expected: 0
    }
}

