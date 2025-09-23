import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, R;
    private static int[][] map;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static List<Integer> makeList(int top, int down, int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i < right; i++) {
            list.add(map[top][i]);
        }

        for (int i = top; i < down; i++) {
            list.add(map[i][right]);
        }

        for (int i = right; i > left; i--) {
            list.add(map[down][i]);
        }

        for (int i = down; i > top; i--) {
            list.add(map[i][left]);
        }

        return list;
    }

    private static void changeMap(List<Integer> list, int left, int right, int top, int down) {
        int idx = 0;

        for (int i = left; i < right; i++) {
            map[top][i] = list.get(idx);
            idx++;
        }

        for (int i = top; i < down; i++) {
            map[i][right] = list.get(idx);
            idx++;
        }

        for (int i = right; i > left; i--) {
            map[down][i] = list.get(idx);
            idx++;
        }

        for (int i = down; i > top; i--) {
            map[i][left] = list.get(idx);
            idx++;
        }
    }


    private static void operation() {
        int top = 0, down = N - 1;
        int left = 0, right = M - 1;

        while (top <= down && left <= right) {
            List<Integer> list = makeList(top, down, left, right);
            int value=list.size();
            int para=R%value;

            List<Integer> rotated=new ArrayList<>();
            for (int i=0;i<value;i++){
                rotated.add(list.get((i+para)%value));
            }
            changeMap(rotated, left, right, top, down);
            left++;
            right--;
            top++;
            down--;
        }
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        init();

        operation();

        printMap();
    }
}
