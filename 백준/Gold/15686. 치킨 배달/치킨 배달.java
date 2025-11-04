import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N,M;
    private static int[][] map;
    private static boolean[] selected;
    private static List<int[]> chickens;
    private static List<int[]> homes;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][N];
        chickens=new ArrayList<>();
        homes=new ArrayList<>();

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                //0 : 빈 칸 / 1 : 집 / 2 : 치킨집
                map[i][j]=Integer.parseInt(st.nextToken());

                if (map[i][j]==2) chickens.add(new int[]{i,j});
                if (map[i][j]==1) homes.add(new int[]{i,j});
            }
        }
        selected=new boolean[chickens.size()];
    }

    //select : 선택된 치킨집 수
    private static void combination(int select,int count){
        if (count==M){
            int dis=calculateDistance();

            distanceSum=Math.min(dis,distanceSum);
            return;
        }

        if (select>=chickens.size()) return;

        selected[select]=true;
        combination(select+1,count+1);
        selected[select]=false;

        combination(select+1,count);
    }

    private static int distanceSum=Integer.MAX_VALUE;
    //거리 측정
    private static int calculateDistance(){
        int disSum=0;

        for (int i=0;i<homes.size();i++){
            int[] home=homes.get(i);
            int minDis=Integer.MAX_VALUE;

            for (int j=0;j<chickens.size();j++){
                if (!selected[j]) continue;
                int[] chicken=chickens.get(j);
                int dis=Math.abs(chicken[0]-home[0])+Math.abs(chicken[1]-home[1]);
                minDis=Math.min(dis,minDis);
            }
            disSum+=minDis;
        }
        return disSum;
    }

    public static void main(String[] args) throws IOException {
        init();
        combination(0,0);
        System.out.println(distanceSum);
    }
}
