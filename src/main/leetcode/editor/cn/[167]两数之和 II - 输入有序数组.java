
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int res = numbers[left]+numbers[right];
            if(res==target){
                return new int[]{++left,++right};
            } else if (res > target) {
                right--;
            }else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
