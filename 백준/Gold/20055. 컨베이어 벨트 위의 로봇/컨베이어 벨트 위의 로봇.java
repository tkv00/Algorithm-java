import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] robot;
    static StringTokenizer st;
    static int zero = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            //==올리는 위치에서 로봇 올리기==
            cnt += 1;

            //1단계 -> 벨트 회전
            rotateRobot(robot);
            rotate(arr);

            //로봇이 제일 끝이라면
            if(robot[N-1]){
                //내리기
                robot[N-1]=false;
            }


            //2단계 -> 가장 먼저 올라간 로봇 부터 벨트 회전 방향으로 이동
            for (int i = N - 1; i > 0; i--) {
                //i에 로봇이 없어야 함.

                if (robot[i - 1] && !robot[i] && arr[i] > 0) {
                    //로봇 이동
                    robot[i - 1] = false;
                    robot[i] = true;
                    //내구도 감소
                    arr[i] -= 1;
                }

            }
            //로봇이 제일 끝이라면
            if(robot[N-1]){
                robot[N-1]=false;
            }

            //3단계 -> 올리는 위치에 내구도 0이아니면
            if (arr[0] > 0) {
                robot[0] = true;
                //내구도 감소
                arr[0] -= 1;
            }
            //로봇이 제일 끝이라면
            if (zero(arr) >= K) {
                //내리기
                break;
            }

        }
        System.out.println(cnt);
    }

    //한 칸씩 이동 하는 로직
    static void rotate(int[] arr) {
        //마지막 수 저장
        int end = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = end;
    }

    static void rotateRobot(boolean[] robot) {
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
    }

    static int zero(int[] arr) {
        int cnt = 0;
        for (int j : arr) {
            if (j == 0) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
