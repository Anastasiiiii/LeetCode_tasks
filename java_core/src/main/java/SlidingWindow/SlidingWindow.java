package SlidingWindow;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0,20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    //return maximum sum in
    //a subarray of size k

    //n must be greater
    private static int maxSum(int[] arr, int n, int k){
        if(n <= k) {
            System.out.println("Invalid");
            return -1;
        }

        //Compute sum of first window of size k
        int max_sum = 0;
        for(int i = 0; i < k; i++){
            max_sum += arr[i];
        }

        //Compute sums of remaining windows by removing first element
        //of previous window and adding last element of current window.
        int window_sum = max_sum;
        for(int i = k; i < n; i++){
            window_sum += arr[i] - arr[i-k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }
}
