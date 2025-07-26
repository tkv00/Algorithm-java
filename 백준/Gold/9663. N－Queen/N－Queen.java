import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] map;
    private static int result=0;
    private static void DFS(int depth){
        if(depth==N){
            result++;
            return;
        }

        for(int i=0;i<N;i++){
            //depth:행  i:열
            map[depth]=i;
            if(isValid(depth)){
                DFS(depth+1);
            }
        }
    }
    private static boolean isValid(int row){
        for(int i=0;i<row;i++){
            //열이 같은 경우
            if(map[row]==map[i]) return false;
            
            //대각선이 같은 경우
            if(Math.abs(row-i)==Math.abs(map[row]-map[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N];
        DFS(0);
        System.out.println(result);
    }    
}
