import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] belt;
    private static boolean[] robots; //로봇 위치 메서드
    private static int step = 0;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

    }

    //벨트 회전 함수
    private static void rotationBelt() {
        int temp = belt[2 * N - 1];

        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i]=belt[i-1];
        }

        belt[0]=temp;
    }

    //로봇 회전 함수
    private static void rotationRobot() {
        for (int i = N-1; i > 0 ; i--) {
           robots[i]=robots[i-1];
        }

        robots[0]=false;
        robots[N-1]=false;
    }

    //내구도가 0인 칸 K이상 검증 메서드
    private static boolean isEnd() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (belt[i] == 0) cnt++;
        }
        return cnt >= K;
    }

    private static void operation() {
        while (!isEnd()) {

            /**
             * 올리는 위치 index : 0
             * 내리는 위치 index : N-1
             */
            //1단계 - 로봇+벨트 회전
            rotationRobot();
            rotationBelt();

            //2단계 - 0~N-1까지 로봇
            for (int i =N-2;i>=0;i--) {
                if (robots[i]) {
                    //이동하려는 칸에 로봇 X + 내구도 1이상
                    if (!robots[i + 1] && belt[i + 1] >= 1) {
                        //로봇 이동
                        robots[i + 1] = true;
                        robots[i] = false;

                        //내구도 1감소
                        belt[i + 1]--;
                    }
                }
            }
            robots[N-1]=false;

            //3단계 - 올리는 위치에 로봇 올리기
            if (belt[0] > 0) {
                belt[0]--;
                robots[0] = true;
            }

            step++;
        }

    }

    private static void printMap() {
        for (int i = 0; i < 2 * N; i++) {
            System.out.print(belt[i] + " ");
        }
        System.out.println();
        System.out.println("=================");
        for (int i = 0; i < N; i++) {
            System.out.print(robots[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(step);
    }
}
