package leetCodeProblems;

public class CountOdds {
    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countOdds(3, 7));  // 3 (3,5,7)
        System.out.println(countOdds(8, 10)); // 1 (9)
        System.out.println(countOdds(0, 0));  // 0
        System.out.println(countOdds(1, 1));  // 1
        System.out.println(countOdds(0, 10)); // 5 (1,3,5,7,9)
        
        // Interactive test
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while(true) {
            System.out.print("Enter low high (or 'quit'): ");
            String[] input = sc.nextLine().trim().split(" ");
            if(input[0].equals("quit")) break;
            if(input.length == 2) {
                int low = Integer.parseInt(input[0]);
                int high = Integer.parseInt(input[1]);
                System.out.println("Count: " + countOdds(low, high));
            }
        }
        sc.close();
    }
}

