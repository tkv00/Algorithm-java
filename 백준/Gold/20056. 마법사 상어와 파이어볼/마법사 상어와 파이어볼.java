import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;


        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    private static int N, M, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static Queue<FireBall> fires;
    private static ArrayList<FireBall>[][] map;
    private static int DIV = 5;
    private static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fires = new LinkedList<>();
        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            FireBall fireBall = new FireBall(r - 1, c - 1, m, s, d);
            fires.offer(fireBall);
        }

    }

    private static void operation() {
        for (int i = 0; i < K; i++) {
            for (int r=0;r<N;r++){
                for (int c=0;c<N;c++){
                    map[r][c].clear();
                }
            }
            //이동
            while (!fires.isEmpty()) {
                //방향으로 이동.
                FireBall ball = fires.poll();

                int nr = ((ball.r + dr[ball.d] * ball.s) % N + N) % N;
                int nc = ((ball.c + dc[ball.d] * ball.s) % N + N) % N;
                //map[ball.r][ball.c].remove(ball);


                map[nr][nc].add(ball);
                ball.r = nr;
                ball.c = nc;

            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c].isEmpty()) continue;
                    if (map[r][c].size() == 1) fires.offer(map[r][c].get(0));
                    if (map[r][c].size() >= 2) {
                        ArrayList<FireBall> list = map[r][c];

                        //합치기
                        int sumOfWeight = 0; //질량 합계
                        int sumOfVelocity = 0; // 속력 합계
                        int odd = 0;//방향 홀수
                        int even = 0;//빙향 짝수
                        int size = list.size();

                        //질량이 0인 경우
                        for (FireBall fb : list) {
                            sumOfWeight += fb.m;
                            sumOfVelocity += fb.s;
                            if (fb.d % 2 == 0) even++;
                            else odd++;
                        }

                        int pW = sumOfWeight / DIV;
                        int pC = sumOfVelocity / size;

                        if (pW <= 0) continue;

                        //방향이 0 2 4 6
                        if (odd == 0 || even == 0) {
                            for (int k = 0; k <= 6; k += 2) {
                                FireBall fireBall = new FireBall(r, c, pW, pC, k);
                                fires.offer(fireBall);
                                map[r][c].add(fireBall);
                            }
                        } else {
                            for (int k = 1; k <= 7; k += 2) {
                                FireBall fireBall = new FireBall(r, c, pW, pC, k);
                                fires.offer(fireBall);
                                map[r][c].add(fireBall);
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        operation();
        int answer = 0;

        while (!fires.isEmpty()) {
            FireBall now = fires.poll();
            answer += now.m;
        }
        System.out.print(answer);
    }
}
