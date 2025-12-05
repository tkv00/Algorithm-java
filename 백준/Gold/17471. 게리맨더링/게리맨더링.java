
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static final int DONT = -1;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] peoples;
    private static Map<Integer, List<Integer>> graph;
    private static int[] arr;
    private static final int BLUE = 1;
    private static final int RED = 2;
    private static int result = Integer.MAX_VALUE;

    private static void combination(int idx) {
        if (idx > N) {
            //영역이 1개 이하인 경우
            if (countDivision() <= 1) return;
            //영역이 연결되어 있지 않은 경우
            if (!isConnected()) return;


            result = Math.min(result, countDiff());
            return;
        }
        arr[idx] = BLUE;
        combination(idx + 1);

        arr[idx] = RED;
        combination(idx + 1);
    }

    //나누어진 영역 개수 세기
    private static int countDivision() {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(arr[i]);
        }

        return set.size();
    }

    //인구 수 차이 세기
    private static int countDiff() {
        int redCount = 0;
        int blueCount = 0;

        for (int i = 1; i <= N; i++) {
            if (arr[i] == RED) redCount += peoples[i];
            if (arr[i] == BLUE) blueCount += peoples[i];
        }

        return Math.abs(redCount - blueCount);
    }

    private static boolean[] visited;

    //각 영역들이 이어져 있는지 확인
    private static boolean isConnected() {
        visited = new boolean[N + 1];

        //RED 첫 번째 인덱스 넣기
        for (int i = 1; i <= N; i++) {
            if (arr[i] == RED) {
                bfs(i);
                break;
            }
        }

        //BLUE 첫 번째 인덱스 넣기
        for (int i = 1; i <= N; i++) {
            if (arr[i] == BLUE) {
                bfs(i);
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (graph.get(now)==null) continue;

            for (int next : graph.get(now)) {
                if (visited[next]) continue;
                if (arr[next] != arr[now]) continue;

                visited[next] = true;
                q.offer(next);
            }
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        arr = new int[N + 1];
        graph = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) continue;

            for (int j = 0; j < num; j++) {
                int node = Integer.parseInt(st.nextToken());
                graph.putIfAbsent(i, new ArrayList<>());
                graph.putIfAbsent(node, new ArrayList<>());

                graph.get(i).add(node);
                graph.get(node).add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        combination(1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
