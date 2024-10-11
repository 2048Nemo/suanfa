package 我爱坐地铁;

import java.util.Scanner;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 我爱坐地铁
 * @Author: nemo2048
 * @CreateTime: 2024-10-10  20:32
 * @Description: TODO
 * @Version: 1.0
 */
public class 我爱坐地铁 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0;
        //dp map
        int map[][] = null, res[][] = null;

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            m = in.nextInt();
            //初始化 map 和res
            map = new int[n + 1][n + 1];
            res = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = in.nextInt();
                }
                //顺便初始化一下不影响，懒得写for了
                for(int k = 1; k <= m; k++){
                    res[i][k] = Integer.MAX_VALUE - 100000;
                }
                res[i][1] = -1;
            }
        }

        //开始解题
        //res[i][j] 定义为从i站开始到回来j次换乘 累积的疲劳值
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    int prev = res[i][j];
                    if (res[i][j] == -1){
                        prev = 0;
                    }
                    if (map[k][i] == -1){
                        continue;
                    }
                    res[i][j] = Math.min( prev + map[k][i]+ map[i][k],res[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(res[i][j] +" ");
            }
            System.out.println();
        }
    }
}

// 输入
//5 3
//        -1 5 1 3 4
//        5 -1 4 4 3
//        1 4 -1 5 1
//        3 4 5 -1 5
//        4 3 1 5 -1

//-1 2 6
//-1 6 8
//-1 2 6
//-1 6 9
//-1 2 6