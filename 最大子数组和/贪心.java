package 最大子数组和;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 最大子数组和
 * @Author: nemo2048
 * @CreateTime: 2024-10-09  14:48
 * @Description: TODO
 * @Version: 1.0
 */
class 贪心 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int presum ,cur ;
        for ( presum =cur= 0;cur < len;cur++) {
            //如果cur指针之前的和都是负数的话则抛弃，重新计数
            if (presum < 0){
                presum = 0;
            }
            presum = nums[cur ]  + presum ;
            res = Math.max(res, presum);
        }

        return res;
    }
}