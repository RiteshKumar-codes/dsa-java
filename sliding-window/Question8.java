class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0){
            return "";
        }
        // frequency map for character in t
        int[] freq = new int [128];
        for(char c: t.toCharArray()){
            freq[c]++;
        }

        int left = 0;
        int right= 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right<s.length()){
            char r = s.charAt(right);
            //if character in s is part of t, decrese required
            if(freq[r]>0){
                required--;
            }
            freq[r]--;
            right++;

           // try shrinking the window
           while(required==0){
            // update minimum window
            if(right-left<minLen){
                minLen = right-left;
                start = left;
            }
            char l = s.charAt(left);
            freq[l]++;

             // If removing this character makes the window invalid
                if (freq[l] > 0) {
                    required++;
                }

                left++;
           }

        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start,start+minLen);
    }
}