import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<Integer>[] parties;
    private static int result = 0;

    private static int findParent(int a) {
        if (parents[a] == a) return a;

        return parents[a] = findParent(parents[a]);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a > b) parents[a] = b;
        else parents[b] = a;
    }

    private static int[] parents;
    private static boolean[] knowPeople;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//사람 수
        M = Integer.parseInt(st.nextToken());//파티 수

        parents = new int[N + 1];
        parties = new List[M];
        knowPeople=new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        for (int i = 0; i < people; i++) {
            int num = Integer.parseInt(st.nextToken());
            knowPeople[num] = true;
        }

        // 각 파티의 참석자 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void unionPeople() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < parties[i].size() - 1; j++) {
                union(parties[i].get(j), parties[i].get(j + 1));
            }
        }
    }

    private static void operation() {
        for (int i = 0; i < M; i++) {
            boolean flag=true;
            for (int person:parties[i]){
                int root=findParent(person);
                for (int k=1;k<=N;k++){
                    if (knowPeople[k] && root==findParent(k)){
                        flag=false;
                        break;
                    }
                }
            }
            if (!flag) continue;
            result++;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        unionPeople();
        operation();

        System.out.println(result);
    }
}
