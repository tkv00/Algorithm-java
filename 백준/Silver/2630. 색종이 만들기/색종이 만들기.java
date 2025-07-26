import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static int[][] map;
    private static int[] result;
    private static boolean isValid(int x,int y,int size){
        int init=map[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(init!=map[i][j]) return false;
            }
        }
        return true;
    }
    private static void cutting(int x,int y,int N){
        if(isValid(x, y, N)){
            result[map[x][y]]++;
            return;
        }
        int size=N/2;
        cutting(x, y, size);
        cutting(x+size, y, size);
        cutting(x, y+size, size);
        cutting(x+size, y+size, size);
    }
    public static void main(String[] args) throws IOException{
        result=new int[2];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        cutting(0, 0, N);
        StringBuilder sb=new StringBuilder();
        for(int x:result){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
    
}
