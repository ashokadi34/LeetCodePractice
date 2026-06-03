package leetCodeProblems;

public class EarliestFinishTimeII {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, 
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;
        
        int minLandFinish = Integer.MAX_VALUE;
        int minWaterFinish = Integer.MAX_VALUE;
        
        // Find minimum finish times for each category
        for (int i = 0; i < n; i++) {
            minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);
        }
        
        for (int j = 0; j < m; j++) {
            minWaterFinish = Math.min(minWaterFinish, waterStartTime[j] + waterDuration[j]);
        }
        
        // Option 1: Land first (minimum finish land), then each water ride
        for (int j = 0; j < m; j++) {
            int waterStart = Math.max(minLandFinish, waterStartTime[j]);
            int finishTime = waterStart + waterDuration[j];
            minFinishTime = Math.min(minFinishTime, finishTime);
        }
        
        // Option 2: Water first (minimum finish water), then each land ride
        for (int i = 0; i < n; i++) {
            int landStart = Math.max(minWaterFinish, landStartTime[i]);
            int finishTime = landStart + landDuration[i];
            minFinishTime = Math.min(minFinishTime, finishTime);
        }
        
        return minFinishTime;
    }

    public static void main(String[] args) {
        EarliestFinishTimeII sol = new EarliestFinishTimeII();

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
