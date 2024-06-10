import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] visit;

    public static StringTokenizer st;
    public static int cnt = 0;
    public static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new int[100001];
        queue.add(N);
        visit[N]=1;


        bfs();
        System.out.println(visit[M]-1);
       

    }

    public static void bfs() {



        while (!queue.isEmpty()) {

            int newX = queue.poll();
            if(visit[M]!=0)return;

            for (int i = 0; i < 3; i++) {

                if (newX > 0 && visit[newX - 1]==0) {
                    queue.add(newX - 1);
                    visit[newX - 1]= visit[newX]+1;
                }
                if (newX < 99999 && visit[newX + 1]==0) {
                    queue.add(newX + 1);
                    visit[newX + 1] = visit[newX]+1;
                }
                if (newX * 2 < 100001 && visit[newX * 2]==0) {
                    queue.add(newX * 2);
                    visit[newX * 2] = visit[newX]+1;
                }
            }

        }


    }
}
