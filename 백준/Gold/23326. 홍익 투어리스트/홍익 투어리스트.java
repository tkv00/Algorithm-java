import java.io.*;
import java.util.*;

public class Main {
    private static int N, Q;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int ORDER = 1;
    private static final int MOVE = 2;
    private static final int PRINT = 3;
    //도현이 현재 위치
    private static int pos = 1;
    private static TreeSet<Integer> set;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        set = new TreeSet<>();
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int loc = 1; loc <= N; loc++) {
            int num = Integer.parseInt(st.nextToken());
            if (num==1) set.add(loc);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == PRINT) {
                print();
            } else {
                int num = Integer.parseInt(st.nextToken());

                if (order == ORDER) {
                    specify(num);
                } else if (order == MOVE) {
                    move(num);
                }
            }
        }
    }

    //1번
    private static void specify(int loc) {
        //명소 지정 해제
        if (set.contains(loc)) {
            set.remove(loc);
        }
        //명소 지정
        else {
            set.add(loc);
        }
    }

    //2번
    private static void move(int x) {
        pos = (pos + x - 1) % N + 1;
    }

    //3번
    private static void print() {

        if (set.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }

        Integer next=set.ceiling(pos);

        //시계 방향으로 돌지 않아도 되는 경우
        if (next!=null){
            sb.append(next-pos).append("\n");
        }
        //시계 방향으로 돌아야 하는 경우
        else{
            int first=set.first();
            sb.append(N-pos+first).append("\n");
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        System.out.print(sb);
    }
}
