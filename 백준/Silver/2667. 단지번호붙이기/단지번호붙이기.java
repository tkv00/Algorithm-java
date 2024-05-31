import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[][] check;
    public static StringBuilder res = new StringBuilder();
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int dangi;
    public static ArrayList<Integer> dangisize = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        check = new boolean[N][N];
        arr = new int[N][N];
        dangi=1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1&&!check[i][j]) {
                    dangi=0;
                    dfs(i, j);
                    dangisize.add(dangi);



                }
            }
        }

        res.append(dangisize.size()).append('\n');
        Collections.sort(dangisize);
        for(int t:dangisize){
            res.append(t).append('\n');
        }
        System.out.println(res);


    }

    public static void dfs(int x, int y) {
        check[x][y]=true;
        dangi++;

        for (int i = 0; i < 4; i++) {

            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if ((new_x >= 0 && new_x < N) && (new_y >= 0 && new_y < N) &&
                    (!check[new_x][new_y]) && (arr[new_x][new_y] == 1)) {

                dfs(new_x, new_y);
            }
        }

    }
}
