import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static BufferedReader br;
    private static char[][] map;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        sb=new StringBuilder();

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    //적록색약이 아닌 사람
    private static void isNotBlindness() {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                cnt++;

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = now[0] + dx[d];
                        int nc = now[1] + dy[d];

                        if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc] == map[i][j]) {
                            q.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        sb.append(cnt).append(" ");
    }

    //적록색약인 사람
    private static void blindness(){
        int cnt=0;
        Queue<Object[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[N][N];

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (visited[i][j])continue;

                q.offer(new Object[]{i,j,map[i][j]});
                visited[i][j]=true;
                cnt++;

                while (!q.isEmpty()){
                    Object[] now=q.poll();

                    for (int d=0;d<4;d++){
                        int nr=(int)now[0]+dx[d];
                        int nc=(int)now[1]+dy[d];

                        if(isValid(nr,nc) && !visited[nr][nc]){
                            //빨강 혹은 초록색인 경우 => 같은 영역
                            if ((char)now[2] == 'R' || (char) now[2]=='G'){
                                if (map[nr][nc]=='B') continue;
                                q.offer(new Object[]{nr,nc,map[nr][nc]});
                                visited[nr][nc]=true;
                            }
                            else{
                                if (map[nr][nc]=='B'){
                                    visited[nr][nc]=true;
                                    q.offer(new Object[]{nr,nc,map[nr][nc]});
                                }
                            }

                        }
                    }
                }
            }
        }

        sb.append(cnt);
    }
    public static void main(String[] args) throws IOException {
        init();
        isNotBlindness();
        blindness();

        System.out.println(sb);
    }
}
