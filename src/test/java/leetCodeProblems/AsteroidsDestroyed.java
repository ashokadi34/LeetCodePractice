package leetCodeProblems;

import java.util.Arrays;

public class AsteroidsDestroyed {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        long currentMass = mass;
        
        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }
        
        return true;
    }

    public static void main(String[] args) {
        AsteroidsDestroyed sol = new AsteroidsDestroyed();

        // Example 1
        int mass1 = 10;
        int[] asteroids1 = {3, 9, 19, 5, 21};
        System.out.println(sol.asteroidsDestroyed(mass1, asteroids1)); // true

        // Example 2
        int mass2 = 5;
        int[] asteroids2 = {4, 9, 23, 4};
        System.out.println(sol.asteroidsDestroyed(mass2, asteroids2)); // false

        // Test case 3
        int mass3 = 100;
        int[] asteroids3 = {1, 2, 3, 4, 5};
        System.out.println(sol.asteroidsDestroyed(mass3, asteroids3)); // true
    }
}
