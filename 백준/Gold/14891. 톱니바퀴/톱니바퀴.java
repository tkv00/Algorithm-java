import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr=new int[4][8];
    private static StringTokenizer st;
    private static int K;
    //점수 계산 N극 0 S극 1
    private static int getTotalScore(){
        int total=0;
        for(int i=0;i<4;i++){
            //S극
            if(arr[i][0]==1){
                total+= (int) Math.pow(2,i);
            }
        }
        return total;
    }
    //회전 함수 - 1회 기준
    //1 : 시계 방향 -1 : 반시계 방향
    private static void rotate(int dir,int num){
        if(dir==1){
            int temp=arr[num][7];
            for(int i=7;i>0;i--){
                arr[num][i]=arr[num][i-1];
            }
            arr[num][0]=temp;
        }
        if(dir==-1){
            int temp=arr[num][0];
            for(int i=0;i<7;i++){
                arr[num][i]=arr[num][i+1];
            }
            arr[num][7]=temp;
        }

    }
    private static void left(int dir,int num){
        if(num<0)return;
        if(arr[num][2]==arr[num+1][6])
            return;

        left(-dir,num-1);
        rotate(dir,num);
    }

    private static void right(int dir,int num){
        if(num>3)
            return;
        if(arr[num][6]==arr[num-1][2])
            return;
        right(-dir,num+1);
        rotate(dir,num);
    }
    private static void operation(int dir,int num){
        left(-dir,num-1);
        right(-dir,num+1);
        //자기 자신 회전
        rotate(dir,num);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            String str=br.readLine();
            for(int j=0;j<8;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        K=Integer.parseInt(br.readLine());
        //톱니바퀴 번호 / 방향
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int number=Integer.parseInt(st.nextToken())-1;
            int dir=Integer.parseInt(st.nextToken());

            operation(dir,number);
        }

        System.out.print(getTotalScore());
    }
}
