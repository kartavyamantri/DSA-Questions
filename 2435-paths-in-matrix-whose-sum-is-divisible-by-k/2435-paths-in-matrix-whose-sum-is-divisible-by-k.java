class Solution {
//     public int solve(int row, int col, int[][] grid, int currSum, int k) {
//         if(row >= grid.length || col >= grid[0].length) return 0;
//         if(row == grid.length - 1 && col == grid[0].length - 1) return (currSum + grid[row][col]) % k == 0 ? 1 : 0;

//         int down = solve(row + 1, col, grid, (currSum + grid[row][col]) % k, k);
//         int right = solve(row, col + 1, grid, (currSum + grid[row][col]) % k, k);

//         return down + right;
//     }

// public int numberOfPaths(int[][] grid, int k) {
//         return solve(0, 0, grid, 0, k);
//     }

    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1_000_000_007;

        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m+1][n+1][k+1];

        for(int rem = 0; rem < k; rem++){
            memo[m-1][n-1][rem] = ((rem + grid[m-1][n-1]) % k == 0) ? 1 : 0;
        }

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                for (int rem = 0; rem < k; rem++) {
                    if (r == m - 1 && c == n - 1) continue;

                    int newrem = (rem + grid[r][c]) % k;
                    int down  = memo[r + 1][c][newrem];
                    int right = memo[r][c + 1][newrem];

                    memo[r][c][rem] = (down + right) % MOD;
                }
            }
        }

        return memo[0][0][0];
    }
}