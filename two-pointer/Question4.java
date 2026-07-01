class Solution {
    public int[] sortedSquares(int[] nums) {
       int n = nums.length;

       // Seprate two list of negative and positive number
       ArrayList <Integer> positive = new ArrayList<>();
       ArrayList <Integer> negative = new ArrayList<>();
       
       for(int i = 0; i<n; i++){
        if(nums[i]>=0){
           positive.add(nums[i]);
        }
        else{
            negative.add(nums[i]);
        }
       }

       // Square both the list 

       for(int m = 0;m<positive.size();m++){
         positive.set(m,positive.get(m)*positive.get(m));
       }

       for(int p = 0;p<negative.size();p++){
         negative.set(p,negative.get(p)*negative.get(p));
       }

       // Reverse the negative array because after squaring it the array is sorted in decresing order

       Collections.reverse(negative);

       // Merge both the list and store in a new array

       int[] result = new int [n];
       int left = 0;
       int right = 0;
       int k = 0;

       while(left<negative.size() && right<positive.size()){
        if(negative.get(left)>=positive.get(right)){
            result[k] = positive.get(right);
            right++;
            k++;

        }
        else{
            result[k] = negative.get(left);
            left++;
            k++;
        }
       }
       while(left<negative.size()){
        result[k] = negative.get(left);
        k++;
        left++;
       }
       while(right<positive.size()){
        result[k] = positive.get(right);
        k++;
        right++;
       }

       return result;

    }
}