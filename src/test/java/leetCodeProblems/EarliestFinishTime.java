package leetCodeProblems;

public class EarliestFinishTime {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, 
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Option 1: Land first, then water
                int landFinish = landStartTime[i] + landDuration[i];
                int waterStart1 = Math.max(landFinish, waterStartTime[j]);
                int finish1 = waterStart1 + waterDuration[j];
                
                // Option 2: Water first, then land
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart2 = Math.max(waterFinish, landStartTime[i]);
                int finish2 = landStart2 + landDuration[i];
                
                minFinishTime = Math.min(minFinishTime, Math.min(finish1, finish2));
            }
        }
        
        return minFinishTime;
    }

    public static void main(String[] args) {
        EarliestFinishTime sol = new EarliestFinishTime();

        // Example 1
        int[] landStartTime1 = {2, 8};
        int[] landDuration1 = {4, 1};
        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};
        System.out.println(sol.earliestFinishTime(landStartTime1, landDuration1, 
                                                   waterStartTime1, waterDuration1)); // 9

        // Example 2
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        System.out.println(sol.earliestFinishTime(landStartTime2, landDuration2, 
                                                   waterStartTime2, waterDuration2)); // 14
    }
}
