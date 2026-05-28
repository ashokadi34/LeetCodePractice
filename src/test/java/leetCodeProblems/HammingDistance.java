package leetCodeProblems;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
//Test cases
    public static void main(String[] args) {
        HammingDistance sol = new HammingDistance();

        System.out.println(sol.hammingDistance(1, 4)); // 2
        System.out.println(sol.hammingDistance(3, 1)); // 1
    }
}
