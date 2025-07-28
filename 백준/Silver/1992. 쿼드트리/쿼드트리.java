import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int[][]map;
    private static StringTokenizer st;
    private static StringBuilder sb=new StringBuilder();
    private static boolean whatIsNumber(int x,int y,int size){
        int init=map[x][y];
        for(int i=x;i<size+x;i++){
            for(int j=y;j<size+y;j++){
                if(map[i][j]!=init) return false;
            }
        }
        return true;
    }
    private static void solution(int x,int y,int N){
        int init=map[x][y];
       
        if(whatIsNumber(x, y, N)){
            sb.append(init);
            return;
        }
         
        int size=N/2;
        
         sb.append("(");
        solution(x, y, size);
        solution(x, y+size, size);
        solution(x+size, y, size);
        solution(x+size, y+size, size);
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=0;i<N;i++){
            String str=br.readLine();
            String[] strs=str.split("");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(strs[j]);
            }
        }
        solution(0, 0, N);
        System.out.println(sb);
    }
    
}
