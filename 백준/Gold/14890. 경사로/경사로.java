import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 경사로 높이 : 1 / 길이 : L
     */
    private static int N,L;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        map=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    //경사로를 설치하지 않아도 되는 경우
    private static boolean doNotInstall(int[] arr){
        int init=arr[0];
        for(int i=1;i<arr.length;i++){
            if(init!=arr[i]) return false;
            init=arr[i];
        }
        return true;
    }

    //경사로의 설치가 가능한가
    private static boolean isValidInstall(int[] arr){
        //높이가 1이상 차이나는 경우
        int init=arr[0];
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-init)>1) return false;
            init=arr[i];
        }

        boolean[] visited=new boolean[N];

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){

                //작은 부분 시작
                if(arr[i]>arr[i+1]){
                    int cnt=0;
                    for(int k=i+1;k<arr.length ;k++){
                        if(cnt==L) break;
                        if(visited[k])return false;
                        if(arr[k]!=arr[i+1]) return false;
                        visited[k]=true;
                        cnt++;
                    }
                    if(cnt<L) return false;

                }else{
                    int cnt=0;
                    for(int k=i; k>=0 ;k--){
                        if(cnt==L) break;
                        if(visited[k])return false;
                        if(arr[k]!=arr[i]) return false;
                        visited[k]=true;
                        cnt++;
                    }
                    if(cnt<L) return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        init();
        int answer=0;

        //행부터
        for(int i=0;i<map.length;i++){
            if(doNotInstall(map[i]) || isValidInstall(map[i])) answer++;
        }

        //열 검사
        for(int i=0;i<N;i++){
            int[] arr=new int[N];
            for(int j=0;j<N;j++){
                arr[j]= map[j][i];
            }
            if(doNotInstall(arr) || isValidInstall(arr)) answer++;
        }

        System.out.print(answer);
    }

}
