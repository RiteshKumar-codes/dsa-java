class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int bestMaxEnding = nums[0];
        int bestMinEnding = nums[0];
        int maxRes = nums[0];
        int minRes = nums[0];
        int sum = nums[0];

        for(int i = 1;i<n;i++){

            sum = sum+nums[i];
            // case 1 : find maximum sum in straight array

            bestMaxEnding = Math.max(bestMaxEnding+nums[i],nums[i]);
            maxRes = Math.max(bestMaxEnding,maxRes);


            // case 2: find minimum and subtract from sum of full array

            bestMinEnding = Math.min(bestMinEnding + nums[i],nums[i]);
            minRes = Math.min(minRes,bestMinEnding);

            
        }

        // All elements are negative
        if (maxRes < 0) {
            return maxRes;
        }

        int circularMax = sum - minRes;

        return Math.max(maxRes, circularMax);
    }
}