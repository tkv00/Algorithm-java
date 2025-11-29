
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static Set<String> set;
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) list.add(name);
        }

        list.sort((a,b)->a.compareTo(b));

        System.out.println(list.size());
        for (String name:list){
            System.out.println(name);
        }
    }
}
