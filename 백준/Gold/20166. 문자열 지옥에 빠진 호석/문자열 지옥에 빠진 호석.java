import java.io.*;
import java.util.*;
public class Main {
    private static char[][] map;
    private static int N,M,K;
    private static int[] dx=new int[]{0,0,1,-1,1,1,-1,-1};
    private static int[] dy=new int[]{1,-1,0,0,1,-1,1,-1};
    private static HashMap<String,Integer> hashMap=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        String[] questions=new String[K];
        StringBuilder sb=new StringBuilder();
        map=new char[N][M];

        for(int i=0;i<N;i++){
            String input=br.readLine();
            char[] array=input.toCharArray();
            for(int j=0;j<M;j++){
                map[i][j]=array[j];
            }
        }

        for(int i=0;i<K;i++){
            String input=br.readLine();
           questions[i]=input;
        }

        for(int i=1;i<=5;i++){
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    DFS(1,i,String.valueOf(map[x][y]),x,y);
                }
            }
        }

        for(String str:questions){
            sb.append(hashMap.getOrDefault(str,0)).append("\n");
        }

        System.out.print(sb);
    }

    private static void DFS(int cnt,int depth,String now,int nowX,int nowY){
        if(depth==cnt){
            hashMap.put(now,hashMap.getOrDefault(now,0)+1);
            return;
        }

        for(int i=0;i<8;i++){
            int newX=(nowX+dx[i]+N)%N;
            int newY=(nowY+dy[i]+M)%M;

            DFS(cnt+1,depth,now+map[newX][newY],newX,newY);
        }
    }
}
