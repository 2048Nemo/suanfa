package BFS;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: BFS
 * @Author: nemo2048
 * @CreateTime: 2024-10-10  19:02
 * @Description: https://www.nowcoder.com/practice/e88b41dc6e764b2893bc4221777ffe64
 * @Version: 1.0
 */
public class 走迷宫 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, Xs, Ys, Xt, Yt;

        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();

            Xs = in.nextInt() - 1; // 调整坐标从0开始
            Ys = in.nextInt() - 1;
            Xt = in.nextInt() - 1;
            Yt = in.nextInt() - 1;

            // 创建迷宫
            char[][] map = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = in.next();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // 迷宫输入创建完成
            min = Integer.MAX_VALUE;
            bfs(map, Xs, Ys, Xt, Yt);
        }

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(min);
        }
    }

    // bfs定义为移动到指定地点需要的次数
    public static void bfs(char[][] map, int Xs, int Ys, int Xt, int Yt) {
        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{Xs, Ys});
        visited[Xs][Ys] = true;
        dist[Xs][Ys] = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x == Xt && y == Yt) {
                min = Math.min(dist[x][y], min);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == '.') {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }
}
