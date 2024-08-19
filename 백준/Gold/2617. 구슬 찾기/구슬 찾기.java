import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arrayLists1;
    static ArrayList<Integer>[] arrayLists2;
    static StringTokenizer st;
    static int N;
    static int M;
    static int res;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayLists1 = new ArrayList[N + 1];
        arrayLists2 = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arrayLists1[i] = new ArrayList<>();
            arrayLists2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arrayLists1[first].add(second);
            arrayLists2[second].add(first);
        }
        bfs(arrayLists1);
        bfs(arrayLists2);

        System.out.println(res);

    }

    static void bfs(ArrayList<Integer>[] arrayList) {
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            queue.add(i);
            visited = new boolean[N + 1];
            visited[i] = true;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int newP : arrayList[now]) {
                    if (!visited[newP]) {
                        visited[newP] = true;
                        queue.add(newP);
                        cnt += 1;

                    }

                }
            }
            if (cnt > N / 2) res++;
        }
    }
}
