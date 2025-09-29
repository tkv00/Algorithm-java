import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    private static char[][] map;
    private static int R,C;
    private static final String cant="IMPOSSIBLE";
    private static int[] dx=new int[]{0,0,1,-1};
    private static boolean[][]Fvisited;
    private static boolean[][]Pvisited;
    private static int[] dy=new int[]{1,-1,0,0};
    private static int TIME=Integer.MAX_VALUE;
    private static ArrayDeque<int[]> fires;
    private static ArrayDeque<int[]> jihoons;
    private static boolean isValid(int row,int col){
        return row>=0 && row<R && col>=0 && col<C && map[row][col]!='#';
    }

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        Fvisited=new boolean[R][C];
        Pvisited=new boolean[R][C];

        fires=new ArrayDeque<>();
        jihoons=new ArrayDeque<>();

        for(int i=0;i<R;i++){
            String input=br.readLine();
            map[i]=input.toCharArray();
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]=='J') {
                    if(i==0 || i==R-1 || j==0 || j==C-1){
                        System.out.println(1);
                        System.exit(0);
                    }
                    jihoons.addFirst(new int[]{i, j, 0});
                    Pvisited[i][j]=true;
                }
                if(map[i][j]=='F') {
                    fires.addFirst(new int[]{i, j});
                    Fvisited[i][j]=true;
                }
            }
        }
    }

    private static void BFS(){
        while (true){
            //불 이동
            int sizeOfFires=fires.size();
            for (int i=0;i<sizeOfFires;i++){
                int[] now=fires.pollLast();
                for (int d=0;d<4;d++){
                    int nr=now[0]+dx[d];
                    int nc=now[1]+dy[d];
                    if(isValid(nr,nc) && !Fvisited[nr][nc]){
                        map[nr][nc]='F';
                        Fvisited[nr][nc]=true;
                        fires.addFirst(new int[]{nr,nc});
                    }
                }
            }

            int sizeOfPerson=jihoons.size();
            for (int i=0;i<sizeOfPerson;i++){
                int[] now=jihoons.pollLast();
                for (int d=0;d<4;d++){
                    int nr=now[0]+dx[d];
                    int nc=now[1]+dy[d];
                    if(isValid(nr,nc) && map[nr][nc]=='.' && !Pvisited[nr][nc]){
                        jihoons.addFirst(new int[]{nr,nc,now[2]+1});
                        Pvisited[nr][nc]=true;
                        if (nr==0 || nr==R-1 || nc==0 || nc==C-1){
                            TIME=Math.min(now[2]+1,TIME);
                        }
                    }
                }
            }

            if (jihoons.isEmpty()) break;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        BFS();
        System.out.println(TIME == Integer.MAX_VALUE ? cant : TIME+1);
    }
}
