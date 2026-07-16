class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int res = arr[0];

        for (int i = 1; i < n; i++) {
            int prevNoDel = noDel;
            int prevOneDel = oneDel;

            noDel = Math.max(prevNoDel + arr[i], arr[i]);

            if (prevOneDel == Integer.MIN_VALUE) {
                oneDel = prevNoDel;
            } else {
                oneDel = Math.max(prevNoDel, prevOneDel + arr[i]);
            }

            res = Math.max(res, Math.max(noDel, oneDel));
        }

        return res;
    }
}
