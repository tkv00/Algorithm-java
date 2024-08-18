import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int res = 0;
    static int[] graph;
    static boolean[] visited;
    static boolean[] done;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            visited = new boolean[num + 1];
            done = new boolean[num + 1];
            graph = new int[num + 1];
            res = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                int n = Integer.parseInt(st.nextToken());
                //if(n==j) done[n]=true;
                graph[j] = n;


            }
            for (int j = 1; j <= num; j++) {
                if (!done[j]) {
                    result(j);
                }
            }
            System.out.println(num - res);

        }


    }

    static void result(int node) {
        if (visited[node]) {
            res++;
            done[node] = true;

        }
        visited[node] = true;


        if (!done[graph[node]]) {
            result(graph[node]);
        }
        visited[node] = false;
        done[node] = true;

    }


}
