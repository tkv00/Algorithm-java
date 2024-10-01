import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    //방향
    static StringTokenizer st;
    static long cnt = 1;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) break;
            map = new int[k][3];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            long t=res(k);
            sb.append(cnt + ". " + t + "\n");
            cnt++;
        }

        System.out.println(sb);
    }

    static long res(int n) {
        map[0][2]+=map[0][1];

        //2번째
        map[1][0]+=map[0][1];
        map[1][1]+=Math.min(map[1][0],Math.min(map[0][2],map[0][1]));
        map[1][2]+=Math.min(map[0][2],Math.min(map[0][1],map[1][1]));

        //3행부터
        for (int i=2;i<n;i++){
            //왼쪽
            map[i][0]+=Math.min(map[i-1][0],map[i-1][1]);
            //가운데
            map[i][1]+=Math.min(Math.min(Math.min(map[i-1][0],map[i-1][1]),map[i-1][2]),map[i][0]);
            //오른쪽
            map[i][2]+=Math.min(Math.min(map[i-1][1],map[i-1][2]),map[i][1]);
        }
        return map[n-1][1];
    }



}
