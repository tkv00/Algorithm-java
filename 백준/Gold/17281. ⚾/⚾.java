import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int
            HIT = 1,
            TWO_HIT = 2,
            THREE_HIT = 3,
            HOME_RUN = 4,
            OUT = 0;
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int maxScore;
    private static int[][] info;
    private static boolean[] visited;
    private static int out;
    //선수들 조합 저장
    private static List<int[]> playersInfo;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        info = new int[N][9];
        visited = new boolean[10];
        playersInfo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxScore = 0;
    }

    //점수 계산

    /**
     * @param players 타자 순서 저징 리스트 : 4번타자 제외.
     */
    private static void getScore(int[] players) {
        int innings = 1;
        int score = 0;
        out = 0;
        //현재 주자 상태 - 0:홈 1:1루 2:2루 3:3루
        boolean[] bases = new boolean[4];
        int idx = 1;

        while (innings <= N) {

            int hit = info[innings - 1][players[idx] - 1];

            idx = (idx % 9) + 1;
            switch (hit) {
                case HOME_RUN: {
                    score += countPlayersOnBase(bases) + 1;
                    bases = new boolean[4];
                    break;
                }
                case HIT: {
                    boolean[] newArr = new boolean[4];
                    score += moveBase(bases, HIT, newArr);
                    newArr[1]=true;
                    bases = newArr;
                    break;
                }
                case TWO_HIT: {
                    boolean[] newArr = new boolean[4];
                    score += moveBase(bases, TWO_HIT, newArr);
                    newArr[2] = true;
                    bases = newArr;
                    break;
                }
                case THREE_HIT: {
                    boolean[] newArr = new boolean[4];
                    score += moveBase(bases, THREE_HIT,newArr);
                    newArr[3]=true;
                    bases=newArr;
                    break;
                }
                case OUT:
                    out++;
                    break;
            }

            if (out == 3) {
                innings++;
                bases = new boolean[4];
                out = 0;
            }

        }

        maxScore = Math.max(score, maxScore);
    }

    private static int countPlayersOnBase(boolean[] arr) {
        int cnt = 0;
        for (boolean x : arr) {
            if (x) cnt++;
        }
        return cnt;
    }

    //n칸씩 움직이는 함수
    private static int moveBase(boolean[] arr, int n, boolean[] newArr) {
        int in = 0;
        for (int i = 0; i < 4; i++) {
            //홈에 들어오는 경우
            if (arr[i] && i + n >= 4) {
                in++;
                continue;
            }
            if (arr[i] && i + n < 4) {
                newArr[i + n] = true;
            }
        }
        return in;
    }

    //선수 조합 생성
    private static void createPlayerCombination(int idx, int[] arr) {
        //1번 타자인 경우 -> 4번타자로
        if (idx == 4) {
            arr[idx] = 1;
            visited[1] = true;
            createPlayerCombination(idx + 1, arr);
            visited[1] = false;
            return;
        }

        //종료 조건.
        if (idx == 10) {
            playersInfo.add(arr.clone());
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                arr[idx] = i;
                visited[i] = true;
                createPlayerCombination(idx + 1, arr);
                visited[i] = false;
                arr[idx] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1번 타자 -> 4번 타자.
        init();
        createPlayerCombination(1, new int[10]);

        for (int[] arr : playersInfo) {
            getScore(arr);
        }

        System.out.println(maxScore);
    }
}
