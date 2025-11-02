import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;


    private static int max=0;
    private static final int[][][] combination = {
            // ㅡ, ㅣ
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},

            // 정사각형
            {{0,0},{0,1},{1,0},{1,1}},

            // L, J형 (8가지)
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{1,0},{2,0},{2,-1}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,0},{0,1},{0,2},{1,0}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,-1},{1,-2}},

            // Z, S형 (4가지)
            {{0,0},{0,1},{1,1},{1,2}},
            {{0,0},{1,0},{1,-1},{2,-1}},
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,0},{0,1},{-1,1},{-1,2}},

            // ㅗ형 (4가지)
            {{0,0},{0,1},{0,2},{1,1}}, // ㅜ
            {{0,0},{1,0},{2,0},{1,1}}, // ㅏ
            {{0,0},{0,1},{0,2},{-1,1}}, // ㅗ
            {{0,0},{1,0},{2,0},{1,-1}} // ㅓ
    };


    private static void tetromino() {
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                for (int[][] comb:combination){
                    int sum=0;
                    boolean flag=true;

                    for (int d=0;d<4;d++){
                        int next_row=i+comb[d][0];
                        int next_col=j+comb[d][1];

                        if (next_row<0 || next_row>=N || next_col<0 ||next_col>=M) {
                            flag=false;
                            break;
                        };
                        sum+=map[next_row][next_col];
                    }
                    if (flag){
                        max=Math.max(max,sum);
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        tetromino();

        System.out.println(max);
    }
}
