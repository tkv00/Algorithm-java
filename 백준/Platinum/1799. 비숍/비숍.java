import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N;
    private static int answer;
    private static boolean[] cross_1;
    private static boolean[] cross_2;

    private static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static ArrayList<Point> white;
    private static ArrayList<Point> black;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        cross_1 = new boolean[2 * N + 1];
        cross_2 = new boolean[2 * N + 1];

        //비숍을 둘 수 있는 포인트 저장 배열.
        white = new ArrayList<>();
        black=new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1){
                    if((i+j)%2==0) black.add(new Point(i,j));
                    else white.add(new Point(i,j));
                }
            }
        }
    }

    //대각선 판단
    private static boolean isValidCross(int row, int col) {
        if (cross_1[row + col]) return false;
        if (cross_2[N - col + row - 1]) return false;
        return true;
    }

    //백 트래킹
    private static void backTracking(ArrayList<Point> list,int cnt, int idx) {
        if (idx == list.size()) {
            answer = Math.max(cnt, answer);
            return;
        }

        Point now = list.get(idx);

        if (isValidCross(now.row, now.col)) {
            cross_1[now.row + now.col] = true;
            cross_2[N - now.col + now.row - 1] = true;

            backTracking(list,cnt + 1, idx + 1);

            cross_1[now.row + now.col] = false;
            cross_2[N - now.col + now.row - 1] = false;
        }
        
        backTracking(list,cnt, idx + 1);

    }

    public static void main(String[] args) throws IOException {
        init();
        answer = 0;
        backTracking(white,0, 0);
        int whiteMax=answer;

        answer = 0;
        backTracking(black,0, 0);
        int blackMax=answer;

        System.out.print(whiteMax+blackMax);
    }
}
