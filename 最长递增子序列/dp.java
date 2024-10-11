package 最长递增子序列;

import java.util.Arrays;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 最长递增子序列
 * @Author: nemo2048
 * @CreateTime: 2024-10-09  19:52
 * @Description: TODO
 * @Version: 1.0
 */
public class dp {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[]  dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //dp 数组表示以nums[i]结尾的序列的最长长度
        // j 的话则是从0到i-1的子序列中，找到一个比nums[i]小的数，则将dp[j]加一
        for (int i = 0;i < nums.length; i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]){
                    // 加一的这一步是将nums[i] 这个元素算进来
                    dp[i]  = Math.max(dp[i], dp[j] + 1);

                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
