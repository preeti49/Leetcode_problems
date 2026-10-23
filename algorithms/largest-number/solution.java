class Solution {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            sNums[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(sNums,(a,b)->(b+a).compareTo(a+b));

        if (sNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : sNums) {
            sb.append(num);
        }

        return sb.toString();
    }

}