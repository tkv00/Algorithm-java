import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] dr = new int[]{0, 0, 1, -1};
    private static int[] dc = new int[]{1, -1, 0, 0};
    private static boolean[][] lightMap;
    private static List<int[]>[][] map;
    private static boolean[][] visited;

    private static boolean isValid(int row, int col) {
        return row > 0 && row <= N && col > 0 && col <= N;
    }

    private static int count() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (lightMap[i][j]) cnt++;
            }
        }
        return cnt;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new List[N+1][N+1];
        lightMap = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i=1;i<=N;i++){
            for (int j=1;j<=N;j++){
                map[i][j]=new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[x][y].add(new int[]{a,b});
        }

    }

    private static void operation() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,1});
        lightMap[1][1] = true;
        visited[1][1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            //불켜기
            for (int[] next:map[now[0]][now[1]]){
                if (!lightMap[next[0]][next[1]]){
                    lightMap[next[0]][next[1]]=true;

                    for (int d=0;d<4;d++){
                        int nr=next[0]+dr[d];
                        int nc=next[1]+dc[d];

                        if (isValid(nr,nc) && visited[nr][nc]){
                            q.offer(new int[]{nr,nc});
                            break;
                        }
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (isValid(nr, nc) &&lightMap[nr][nc] &&!visited[nr][nc]) {
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
        System.out.println(count());
    }
}
