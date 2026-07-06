class Solution {

    private int findMax(int []freq){
        int maxCount = -1;
        for(int i = 0;i<256;i++){
            maxCount = Integer.max(maxCount,freq[i]);
        }

        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int [] freq = new int[256];
        int low = 0;
        int res = Integer.MIN_VALUE;

        for(int high = 0; high<n;high++){
            freq[s.charAt(high)]++;
            int maxCount = findMax(freq);
            int len = high-low+1;
            int diff = len-maxCount;

            while(diff>k){
                freq[s.charAt(low)]--;
                low++;

                maxCount = findMax(freq);
                len = high - low + 1;
                diff = len - maxCount;
            }
            len = high - low + 1;
            res = Math.max(res, len);

        }

        return res;
    }
}