import java.util.*;
import java.io.*;

public class Main {
    private static class Point {
        int row;
        int col;
        int data;

        Point(int row, int col, int data) {
            this.row = row;
            this.col = col;
            this.data = data;
        }
    }

    private static int[][] map;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N, M, K;
    //주사위 이동 방향 - 시계(동쪽 시작)
    private static int[] dr = new int[]{0, 1, 0, -1};
    private static int[] dc = new int[]{1, 0, -1, 0};


    //주사위
    private static int[] dice = new int[]{4, 2, 3, 1, 5, 6};
    private static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

    //점수 계산
    private static int getCnt(int row, int col, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col, map[row][col]));
        int cnt = 1;
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.row + dr[d];
                int nc = now.col + dc[d];

                if (isValid(nr, nc, visited) && (map[nr][nc] == map[row][col])) {
                    q.offer(new Point(nr, nc, map[nr][nc]));
                    cnt++;
                    visited[nr][nc] = true;
                }
            }
        }
        return cnt;
    }

    private static boolean isValid(int row, int col, boolean[][] visited) {
        return row >= 0 && row < N && col >= 0 && col < M && !visited[row][col];
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    /* 이동 방향 결정
     *  row = 현재 위치한 주사위 바닥 행 / col = 현재 위치한 주사위 바닥 열
     */
    private static int changeDirection(int nowDir, int row, int col) {
        int diceValue = dice[5];
        int mapValue = map[row][col];

        if (diceValue > mapValue) {
            //90도 회전
            return (nowDir + 1) % 4;
        }

        if (diceValue < mapValue) {
            //90도 반시계 회전
            if (nowDir == 0) return 3;
            else return nowDir - 1;
        }

        return nowDir;
    }

    //주사위 굴리기
    private static void moveDice(int direction) {
        int temp = 0;
        switch (direction) {
            case UP:
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[4];
                dice[4] = dice[5];
                dice[5] = temp;
                break;
            case DOWN:
                temp = dice[5];
                dice[5] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[1];
                dice[1] = temp;
                break;
            case LEFT:
                int value1 = dice[0];
                int value2 = dice[3];
                int value3 = dice[2];
                int value4 = dice[5];
                dice[0] = value2;
                dice[3] = value3;
                dice[2] = value4;
                dice[5] = value1;
                break;
            case RIGHT:
                int value5 = dice[0];
                int value6 = dice[3];
                int value7 = dice[2];
                int value8 = dice[5];
                dice[0] = value8;
                dice[3] = value5;
                dice[2] = value6;
                dice[5] = value7;
                break;
        }
    }

    private static int operation(int row,int col){
        int dir=0;
        int score=0;

        while(K!=0){
            int nr=row+dr[dir];
            int nc=col+dc[dir];

            //1. 이동 방향에 칸이 없는 경우 - 방향 반대로
            if(nr<0 || nr>=N || nc<0 || nc>=M) {
                dir=(dir+2)%4;
                continue;
            }

            //2. 방향으로 굴러간다. - 주사위도
            moveDice(dir);

            //3. 점수 계산.
            score+=getCnt(nr,nc,new boolean[N][M])*map[nr][nc];

            //4.이동방향 결정.
            dir=changeDirection(dir,nr,nc);

            row=nr;
            col=nc;
            K--;
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.print(operation(0,0));
    }
}
