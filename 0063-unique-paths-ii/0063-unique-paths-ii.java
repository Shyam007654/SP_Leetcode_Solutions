class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, no paths are possible
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // Base case: starting cell
        dp[0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] == 1) {
                    // Obstacles block all incoming paths
                    dp[c] = 0;
                } else if (c > 0) {
                    // Add paths coming from the left cell
                    dp[c] += dp[c - 1];
                }
            }
        }

        return dp[n - 1];
    }
}