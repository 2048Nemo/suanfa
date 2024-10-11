package 排序;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 排序
 * @Author: nemo2048
 * @CreateTime: 2024-10-09  21:28
 * @Description: TODO
 * @Version: 1.0
 */

class 快速排序 {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length);
        return nums;
    }

    void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);
        // 去左右子数组进行切分
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    // 最重要的partition 函数 ，专门用来处理 生成切片点并将排序点的两段排好序
    int partition(int[] nums, int lo, int hi){
        return 0;
    }
}