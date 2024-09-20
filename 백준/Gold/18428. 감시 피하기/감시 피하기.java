import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static char[][] map;
    static StringTokenizer st;
    static Queue<Point> teachers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teachers = new LinkedList<>();
        //입력값 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') teachers.add(new Point(i, j));

            }
        }
        //X인 곳에 장애물을 둘 수 있다
        //장애물의 수가 3개일 때 dfs정지 또는 학생들이 모두 감시를 피할 경우 -> 중지
        if (dfs(0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    //감시하는 함수
    static boolean isValid() {
        for (Point now : teachers) {
            for (int i = 0; i < 4; i++) {
                int nx=now.row;
                int ny= now.col;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    //경계 제한
                    //장애물이 있는 경우 -> 다음 좌표 탐색
                    if (nx < 0 || nx >= N ||
                            ny < 0 || ny >= N || map[nx][ny] == 'O') break;

                    //만약 선생이 학생을 감시 할 수 있을 때
                    if (map[nx][ny] == 'S') return false;


                }
            }
        }
        return true;
    }

    //장애물을 배치하는 함수 cnt=장애물 갯수
    static boolean dfs(int cnt) {
        if (cnt == 3) {
            return isValid();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //만약에 장애물을 둘 수 있는 위치라면
                if (map[i][j] == 'X') {
                    //장애물 두기
                    map[i][j] = 'O';
                    if (dfs(cnt + 1)) return true;
                    map[i][j] = 'X';
                }
            }
        }
        return false;
    }
}
