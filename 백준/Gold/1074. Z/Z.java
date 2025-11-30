import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N,r,c;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int cnt=0;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

    }

    private static void division(int row,int col,int size){
        if (row==r && col==c){
            System.out.println(cnt);
            return;
        }

        int newSize=size/2;


        //좌상단
        if (row+newSize>r && col+newSize>c){
            division(row,col,newSize);
        }else{
            cnt+=newSize*newSize;
        }

        //우상단
        if (row+newSize>r && col+newSize<=c){
            division(row,col+newSize,newSize);
        }else{
            cnt+=newSize*newSize;
        }

        //좌하단
        if (row+newSize<=r && col+newSize>c){
            division(row+newSize,col,newSize);
        }else{
            cnt+=newSize*newSize;
        }

        //우하단
        if (row+newSize<=r && col+newSize<=c){
            division(row+newSize,col+newSize,newSize);
        }else{
            cnt+=newSize*newSize;
        }



    }
    public static void main(String[] args) throws IOException {
        init();
        division(0,0,(int)Math.pow(2,N));

    }
}
