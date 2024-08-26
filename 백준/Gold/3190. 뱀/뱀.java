import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean[][] apple;
    static boolean[][] move;
    static int N;
    static int K;
    static int T;
    static int time = 0;
    //왼쪽 회전:1
    //오른쪽 회전:2
    static int[] timeArr = new int[10001];
    static StringTokenizer st;

    //현재 상태(오른쪽 이동 디폴트값)
    static int status = 0;

    //오른쪽회전 이동기준
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int nowRow = 1;
    static int nowCol = 1;
    //뱀 몸통
    static Deque<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        apple = new boolean[N + 1][N + 1];
        move = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            apple[row][col] = true;
        }
        move[1][1] = true;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            //왼쪽 회전:1
            //오른쪽 회전:2
            timeArr[t] = (c == 'L' ? 1 : 2);
        }

        queue = new ArrayDeque<>();
        queue.addFirst(new Point(1, 1));
        //queue.add(new Point(1,1));
        while (true) {
            int newRow = nowRow + dx[status];
            int newCol = nowCol + dy[status];
            //중단 조건
            if (bind(newRow, newCol)) break;

            //시간+
            time += 1;
            //사과 있는경우
            if (apple[newRow][newCol]) {
                //꼬리는 움직이지 않는다.
                apple[newRow][newCol] = false;
                queue.addFirst(new Point(newRow,newCol));
            }
            //사과 없는 경우
            else if (!apple[newRow][newCol]) {
                //지렁이가 전체길이가 움직여야함
                queue.addFirst(new Point(newRow,newCol));
                queue.pollLast();
            }
            nowRow = newRow;
            nowCol = newCol;
            //방향 전환
            switch (timeArr[time]) {
                case 1://왼쪽회전
                    status = (status + 3) % 4;
                    break;
                case 2://오른쪽회전
                    status = (status + 1) % 4;
                    break;
            }
        }

        System.out.println(time + 1);
    }

    //중단조건 함수(벽부딪힐 때만)
    static boolean bind(int row, int col) {
        if (row <= 0 || row > N || col <= 0 || col > N) {
            return true;
        }
        for(Point p:queue){
            if((p.row==row)&&(p.col==col))return true;
        }
        return false;
    }


}
