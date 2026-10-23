class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int real_sum = ((n*(n+1))/2);
        for (int x : nums) {
            sum = sum+x;
        }
        return (real_sum-sum);
        
    }
}