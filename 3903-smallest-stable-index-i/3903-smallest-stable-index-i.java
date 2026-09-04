class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Precompute suffix minimums
        // suffixMin[i] stores min(nums[i..n-1])
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }
        
        // Step 2: Traverse left to right, track prefix maximums,
        // and find the first index where instability score <= k
        int prefixMax = nums[0];
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            
            // Instability score: max(nums[0..i]) - min(nums[i..n-1])
            if (prefixMax - suffixMin[i] <= k) {
                return i; // First stable index found
            }
        }
        
        return -1; // No stable index exists
    }
}