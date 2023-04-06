
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    private int[] prefixNum;

    public NumArray(int[] nums) {
        prefixNum = new int[nums.length];
        prefixNum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixNum[i]= prefixNum[i-1]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0){
            return prefixNum[right];
        }
        return prefixNum[right]-prefixNum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
