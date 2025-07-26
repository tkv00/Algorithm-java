import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static StringTokenizer st;
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
            result[map[x][y]+1]++;
            return;
        }

        int size=N/3;

        //1
        cutting(x, y, size);

        //2
        cutting(x+size, y, size);

        //3
        cutting(x+size*2, y, size);

        //4
        cutting(x, y+size, size);

        //5
        cutting(x, y+size*2, size);

        //6
        cutting(x+size, y+size, size);

        //7
        cutting(x+size, y+size*2, size);

        //8
        cutting(x+size*2, y+size*2, size);

        //9
        cutting(x+size*2, y+size, size);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        result=new int[3];
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
