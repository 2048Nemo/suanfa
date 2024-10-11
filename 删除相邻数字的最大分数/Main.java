package 删除相邻数字的最大分数;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 删除相邻数字的最大分数
 * @Author: nemo2048
 * @CreateTime: 2024-10-10  12:21
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 生成hashmap
        int[] nums = new int[10];
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            nums = new int[n];
//            Arrays.fill(nums, 0);
            for (int i = 0 ;i < n ;i++){
                int anInt = in.nextInt();
                nums[anInt] += 1;
            }
        }

        //开始
        int  sum = nums.length;
        for (int i =0 ;i < nums.length ;i++){
            if (nums[i] >= sum / 2) {
                System.out.println(i);
            }
        }
    }
}