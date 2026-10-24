package leetCodeProblems;


import java.util.Scanner;

public class CountDaysSpentTogether {

    private static final int[] DAYS_IN_MONTH = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int aliceArrive = toDayOfYear(arriveAlice);
        int aliceLeave = toDayOfYear(leaveAlice);
        int bobArrive = toDayOfYear(arriveBob);
        int bobLeave = toDayOfYear(leaveBob);

        int togetherStart = Math.max(aliceArrive, bobArrive);
        int togetherEnd = Math.min(aliceLeave, bobLeave);

        return Math.max(0, togetherEnd - togetherStart + 1);
    }

    private int toDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        int dayOfYear = day;

        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTH[i];
        }

        return dayOfYear;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Alice arrival date (MM-DD): ");
        String arriveAlice = scanner.next();

        System.out.print("Enter Alice leaving date (MM-DD): ");
        String leaveAlice = scanner.next();

        System.out.print("Enter Bob arrival date (MM-DD): ");
        String arriveBob = scanner.next();

        System.out.print("Enter Bob leaving date (MM-DD): ");
        String leaveBob = scanner.next();

        CountDaysSpentTogether solution = new CountDaysSpentTogether();
        int result = solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);

        System.out.println("Output: " + result);

        scanner.close();
    }
}