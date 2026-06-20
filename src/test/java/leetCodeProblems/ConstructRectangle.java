package leetCodeProblems;

import java.util.Arrays;

public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);

        while (area % width != 0) {
            width--;
        }

        return new int[] {area / width, width};
    }

    public static void main(String[] args) {
        ConstructRectangle sol = new ConstructRectangle();

        System.out.println(Arrays.toString(sol.constructRectangle(4)));      // [2, 2]
        System.out.println(Arrays.toString(sol.constructRectangle(37)));     // [37, 1]
        System.out.println(Arrays.toString(sol.constructRectangle(122122))); // [427, 286]
    }
}
