class Solution {
    public int subarraySum(int[] nums, int k){
        int n = nums.length;
        int res = 0;
        int sum = 0;

        HashMap <Integer,Integer> f = new HashMap<>();
        f.put(0,1);//sum=0 occur once

        for(int i = 0; i<n; i++){
            sum += nums[i];
            int prefixSum = sum-k;

            res += f.getOrDefault(prefixSum,0);

            f.put(sum,f.getOrDefault(sum,0)+1);
            
        }
        
        

        return res;
    }
}
