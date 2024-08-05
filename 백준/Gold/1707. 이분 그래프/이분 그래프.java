import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static int T;
    public static int V;
    public static int E;
    public static final int RED = 1;
    public static final int BLUE = -1;
    public static StringTokenizer st;
    public static ArrayList<Integer>[] arrayLists;
    public static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            arrayLists = new ArrayList[V + 1];
            colors = new int[V + 1];
            //리스트 초기화
            for (int j = 0; j <= V; j++) {
                arrayLists[j] = new ArrayList<>();
            }

            //입력값 받기
            for (int k = 0; k < E; k++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arrayLists[start].add(end);
                arrayLists[end].add(start);
            }

            boolean res = false;
            for (int t = 1; t <= V; t++) {
                if (colors[t] == 0) {
                    res = bfs(t, RED);
                }
                if (!res) break;
            }
            if (!res) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
        //이분 그래프가 아닌 경우


    }

    public static boolean bfs(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = color;//일단 빨간색 색칠
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int v : arrayLists[now]) {
                //같은 색깔이면  이분 그래프가 아님
                if (colors[v] == colors[now]) {
                    return false;
                }
                if (colors[v] == 0) {
                    queue.add(v);
                    colors[v] = colors[now] * -1;
                }
            }
        }
        return true;
    }

}


