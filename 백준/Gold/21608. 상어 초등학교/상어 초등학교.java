import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    //입력값 담는 해시맵

    private static HashMap<Integer,Integer[]> map=new HashMap<>();
    private static StringTokenizer st;
    private static int[] dx=new int[]{1,0,-1,0};
    private static int[] dy=new int[]{0,1,0,-1};
    private static int[][] numArr;
    private static BufferedReader br;
    private static int result=0;
    private static List<Integer> studentOrder=new ArrayList<>();
    //만족도 계산
    private static int sumOfNumber(int cnt){
        return cnt == 0 ? 0 : (int) Math.pow(10,cnt-1);
    }
    //입력값 받기
    private static void inputMap(int N) throws IOException {
        for(int i=0;i<N*N;i++){
            st=new StringTokenizer(br.readLine());
            int s1=Integer.parseInt(st.nextToken());
            int s2=Integer.parseInt(st.nextToken());
            int s3=Integer.parseInt(st.nextToken());
            int s4=Integer.parseInt(st.nextToken());
            int s5=Integer.parseInt(st.nextToken());

            map.put(s1,new Integer[]{s2,s3,s4,s5});
            studentOrder.add(s1);
        }
    }
    //경계판단
    private static boolean isValid(int row,int col,int N){
        if(row>=N || col>=N || row<0 || col<0)
            return false;
        return true;
    }
    //만족도 계산
    private static void totalOfNumber(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int cnt=0;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(!isValid(nx,ny,arr.length))
                        continue;
                    Integer[] friends=map.get(arr[i][j]);
                    for(int f:friends){
                        if(arr[nx][ny]==f)
                            cnt++;
                    }
                }
                result+=sumOfNumber(cnt);
            }
        }
    }
    /*
    * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
      2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
      3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    * */
    //arr배열에 삽입
    private static void insertArray(int N){
        for(Integer student:studentOrder){
            int maxFriendCount=-1;
            int maxEmptyCount=-1;
            int finalRow=-1;
            int finalCol=-1;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(numArr[i][j]!=0) continue;
                    int emptyCount=0;
                    int friendCount=0;

                    for(int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];

                        if(!isValid(nx,ny,N)) continue;

                        if(numArr[nx][ny]==0) emptyCount++;
                        else{
                            for(int f:map.get(student)){
                                if(numArr[nx][ny]==f){
                                    friendCount++;
                                    break;
                                }
                            }
                        }
                    }

                    if (friendCount > maxFriendCount ||
                            (friendCount == maxFriendCount && emptyCount > maxEmptyCount) ||
                            (friendCount == maxFriendCount && emptyCount == maxEmptyCount && (i < finalRow || (i == finalRow && j < finalCol)))
                    ) {

                        maxFriendCount=friendCount;
                        maxEmptyCount=emptyCount;
                        finalRow=i;
                        finalCol=j;
                    }
                }
            }
            numArr[finalRow][finalCol]=student;
        }
    }
    public static void main(String[] args) throws IOException {
        int N;
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        numArr=new int[N][N];

        inputMap(N);
        insertArray(N);
        totalOfNumber(numArr);

        System.out.print(result);

    }
}
