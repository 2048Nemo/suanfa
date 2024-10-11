package 最大子数组和;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 最大子数组和
 * @Author: nemo2048
 * @CreateTime: 2024-10-09  14:48
 * @Description: TODO
 * @Version: 1.0
 */
public class dp {

    // dp 选择将dp数组定义为前i个元素中最大的值
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int len = nums.length;
        int presum = 0 ;
        int cur;
        for (cur= 0;cur < len;cur++) {
            //如果cur指针之前的和都是负数的话则抛弃，重新计数
            presum = Math.max(presum + nums[cur], nums[cur]);
            res= Math.max(res, presum);
        }
        return res;
    }
}
