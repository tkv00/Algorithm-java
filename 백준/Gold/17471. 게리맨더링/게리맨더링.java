import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] persons;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static HashMap<Integer, List<Integer>> map;
    private static final int AREA_1 = 1;
    private static final int AREA_2 = 2;
    private static int MIN = Integer.MAX_VALUE;
    //선거구 판단 배열
    private static int[] division;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        persons = new int[N + 1];
        map = new HashMap<>();
        division = new int[N + 1];

        for (int i = 0; i < N; i++) {
            persons[i + 1] = Integer.parseInt(st.nextToken());
            map.put(i + 1, new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int c = 0; c < count; c++) {
                int num = Integer.parseInt(st.nextToken());
                map.get(i + 1).add(num);
            }
        }
    }

    private static void DFS(int depth) {
        if (depth > N) {
            if (isChecked()) {
                MIN = Math.min(diff(), MIN);
            }
            return;
        }


        //선거 1구역 처리
        division[depth] = AREA_1;
        DFS(depth + 1);

        //선거 2구역 처리
        division[depth] = AREA_2;
        DFS(depth + 1);
    }


    //인구수 차이 판단
    private static int diff() {
        int sum1 = 0, sum2 = 0;

        for (int i = 1; i <= N; i++) {
            if (division[i] == AREA_1) sum1 += persons[i];
            if (division[i] == AREA_2) sum2 += persons[i];
        }

        return Math.abs(sum1 - sum2);
    }

    /**
     * 불가능한 방법 2 - 나누어져 있지만 연결되어 있지 않은 경우
     */
    private static boolean isConnected(int start) {
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        visit[start] = true;
        dq.addFirst(start);

        while (!dq.isEmpty()) {
            int now = dq.pollLast();
            for (int x : map.get(now)) {
                //방문하지 않았고 같은 선거구역인 경우
                if (!visit[x] && (division[x] == division[now])) {
                    visit[x] = true;
                    dq.addFirst(x);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (division[start] == division[i] && !visit[i]) return false;
        }
        return true;

    }

    private static boolean isChecked() {
        //선거구 1지역 확인
        int start1=-1,start2=-1;

        for (int i=1;i<=N;i++){
            if(division[i]==AREA_1 && start1==-1) start1=i;
            if (division[i]==AREA_2 && start2==-1) start2=i;
        }

        if(start1==-1 || start2==-1) return false;

        if (!isConnected(start1)) return false;
        if (!isConnected(start2)) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        init();
        DFS(1);

        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }
}
