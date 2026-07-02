class Solution {
    int countTriplets(int sum, int arr[]) {
        // code here
        int n = arr.length;
        int count = 0;
        
        Arrays.sort(arr);
        
        for(int i = 0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            
            
            
            while(left<right){
                
                int tripletSum = arr[i]+arr[left]+arr[right];
                if(tripletSum>=sum){
                    right--;
                }
                else{
                    count = count + (right-left);
                    left++;
                }
            }
        }
        
        return count;
    }
}