package leetCodeProblems;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int i, boolean[] visited) {
        if (i < 0 || i >= arr.length || visited[i]) return false;
        if (arr[i] == 0) return true;

        visited[i] = true;
        return dfs(arr, i + arr[i], visited) || dfs(arr, i - arr[i], visited);
    }

    //Test cases
    public static void main(String[] args) {
        JumpGameIII sol = new JumpGameIII();

        System.out.println(sol.canReach(new int[]{4,2,3,0,3,1,2}, 5)); // true
        System.out.println(sol.canReach(new int[]{4,2,3,0,3,1,2}, 0)); // true
        System.out.println(sol.canReach(new int[]{3,0,2,1,2}, 2));     // false
    }
}
