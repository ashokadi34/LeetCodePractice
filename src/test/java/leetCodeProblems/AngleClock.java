package leetCodeProblems;

public class AngleClock {

    public double angleClock(int hour, int minutes) {
        double hourHand = (hour % 12 + minutes / 60.0) * 30;
        double minuteHand = minutes * 6;
        double diff = Math.abs(hourHand - minuteHand);
        return Math.min(diff, 360 - diff);
    }

    //Test cases
    public static void main(String[] args) {
        AngleClock sol = new AngleClock();

        System.out.println(sol.angleClock(12, 30)); // 165.0
        System.out.println(sol.angleClock(3, 30));  // 75.0
        System.out.println(sol.angleClock(3, 15));  // 7.5
        System.out.println(sol.angleClock(1, 57));  // 76.5
    }
}
