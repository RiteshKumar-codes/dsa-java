lass Solution {
    public int removeDuplicates(int[] arr) {
       int n = arr.length;
       int officer = 0;
       int unique = 1;
       int cm = 1;

       while(cm<n){
        if(arr[cm]==arr[cm-1]){
            cm++;
            continue;
        }
        else {
            arr[officer+1] = arr[cm];
            officer++;
            cm++;
            unique++;
        }
       }
       return unique;
    }
}