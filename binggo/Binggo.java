package binggo;

import java.util.Scanner;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: binggo
 * @Author: nemo2048
 * @CreateTime: 2024-10-10  19:52
 * @Description: TODO
 * @Version: 1.0
 */
public class Binggo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k =0 ,r = 0, l =0 ;

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            k = in.nextInt();
            l = in.nextInt();
            r = in.nextInt();
        }
        //倍数模除，子串（）
        for (int i =l;i <= r ;i++ ){
            if (judge(i,k)){
                System.out.print(i + " ");
            }
        }
    }
    public static boolean judge(int n,int k){
        if (n % k == 0){
            return true;
        }
        if (substr(Integer.toString(n),Integer.toString(k))){
            return true;
        }
        return false;
    }
    public static boolean substr(String n,String k){
        for (int i = 0;i <= n.length() - k.length();i++){
            if (n.substring(i,i+ k.length()).equals(k)){
                return true;
            }
        }
        return false;
    }

}
