package leetCodeProblems;

public class CircleRectangleOverlap {

    public static boolean checkOverlap(int radius, int xCenter, int yCenter,
                                       int x1, int y1, int x2, int y2) {
        // Find closest x on rectangle to circle center
        int closestX = clamp(xCenter, x1, x2);
        // Find closest y on rectangle to circle center
        int closestY = clamp(yCenter, y1, y2);

        // Compute squared distance from circle center to closest point
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;
        int distSq = dx * dx + dy * dy;

        return distSq <= radius * radius;
    }

    private static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));   // true

        // Example 2
        System.out.println(checkOverlap(1, 1, 1, 1, -3, 2, -1));  // false

        // Example 3
        System.out.println(checkOverlap(1, 0, 0, -1, 0, 0, 1));   // true
    }
}
