class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum = 0;
        int low = 0;
        int high = k-1;
        
        for(int i = low;i<=high;i++){
            sum = sum + arr[i];
        }
        
        int result = 0;
        
        while(high<n){
            result = Math.max(result,sum);
            
            low++;
            high++;
            
            if(high==n){
                break;
            }
            
            sum = sum -arr[low-1];
            sum = sum + arr[high];
        }
        
        return result;
    }
}