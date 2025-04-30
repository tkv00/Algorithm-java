import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
private static StringTokenizer st;
private static StringBuilder sb;
private static int[] result;
private static boolean[] visited;
private static int[] arr;
private static int size;
private static void dfs(int k,int depth){
    if(depth==6){
        for(int t:result){
            sb.append(t).append(" ");
        }
        sb.append("\n");
        return;
    }
    for(int i=k;i<size;i++){
        if(!visited[i]){
            visited[i]=true;
            result[depth]=arr[i];
            dfs(i,depth+1);
            visited[i]=false;
        }
    }
}
public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    while(true){
        st=new StringTokenizer(br.readLine());
        size=Integer.parseInt(st.nextToken());
        arr=new int[size];
        if(size==0) {
            break;
        }
        for(int i=0;i<size;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        result=new int[6];
        visited=new boolean[size];
        sb = new StringBuilder();

        dfs(0,0);

        System.out.println(sb);
    }
}


}
