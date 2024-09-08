import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static StringTokenizer st;
    static ArrayList<Point> chicken;
    static ArrayList<Point> city;
    static int res = Integer.MAX_VALUE;
    static boolean[] visited;

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new ArrayList<>();
        chicken = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                //치킨인 경우
                if (t == 2) {
                    chicken.add(new Point(i, j));
                }
                //집인 경우
                if (t == 1) {
                    city.add(new Point(i, j));
                }
            }
        }
        visited=new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(res);

    }

    //거리 재기
    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int i = 0; i < city.size(); i++) {
                int max = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int k = distance(city.get(i).x, city.get(i).y, chicken.get(j).x, chicken.get(j).y);
                        max = Math.min(max, k);
                    }
                }
                sum += max;
            }
            res=Math.min(sum,res);
            return;
        }

        //치킨 집 방문
        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i+1);
            visited[i] = false;
        }
    }

}
