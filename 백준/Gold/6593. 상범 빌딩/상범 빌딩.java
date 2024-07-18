import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class XYZ {
        int x;
        int y;
        int z;

        XYZ(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static int L;
    public static int R;
    public static int C;
    public static StringTokenizer st;
    public static XYZ start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[L + 1][R + 1][C + 1];//층 행 열
            int[][][] res = new int[L + 1][R + 1][C + 1];

            //빌딩값 입력받기
            for (int i = 1; i <= L; i++) {
                for (int j = 1; j <= R; j++) {
                    String line = br.readLine();
                    for (int k = 1; k <= C; k++) {
                        building[i][j][k] = line.charAt(k - 1);
                        //시작값
                        if (building[i][j][k] == 'S') {
                            start = new XYZ(i, j, k);
                            //System.out.println(start.x + " " + start.y + " " + start.z);
                        }
                        //끝점 저장
                        if (building[i][j][k] == 'E') {
                            end = new XYZ(i, j, k);
                           // System.out.println(end.x + " " + end.y + " " + end.z);
                        }
                    }

                }
                br.readLine();
            }
            bfs(building, res, L, R, C, start, end);
        }


    }

    public static void bfs(char[][][] building, int[][][] res, int L, int R, int C, XYZ start, XYZ end) {
        Queue<XYZ> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L + 1][R + 1][C + 1];

        int[] dx = {0, 0, 1, -1, 0, 0};//동 서 남 북 상 하
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        queue.add(start);
        visited[start.x][start.y][start.z] = true;
        res[start.x][start.y][start.z] = 1;
        while (!queue.isEmpty()) {
            XYZ new_xyz = queue.poll();
            int now_x = new_xyz.x;
            int now_y = new_xyz.y;
            int now_z = new_xyz.z;

            for (int i = 0; i < 6; i++) {
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];
                int new_z = now_z + dz[i];

                if (new_x == end.x && new_y == end.y && new_z == end.z) {
                   // System.out.println(Arrays.deepToString(res));
                    System.out.println("Escaped in " + res[now_x][now_y][now_z] + " minute(s).");
                    return;
                }
                if ((new_x > 0 && new_x <= L) && (new_y > 0 && new_y <= R) && (new_z > 0 && new_z <= C)
                        && !visited[new_x][new_y][new_z] && (building[new_x][new_y][new_z] == '.' || building[new_x][new_y][new_z] == 'E')) {
                    queue.add(new XYZ(new_x, new_y, new_z));
                    visited[new_x][new_y][new_z] = true;
                    res[new_x][new_y][new_z] = res[now_x][now_y][now_z] + 1;
                }
            }

        }
        System.out.println("Trapped!");

    }


}
