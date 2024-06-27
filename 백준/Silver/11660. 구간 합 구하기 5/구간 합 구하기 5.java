import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int arraySize;
    public static int qSize;
    public static int [][] array;
    public static int [][] sumArray;
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        arraySize=Integer.parseInt(st.nextToken());
        qSize=Integer.parseInt(st.nextToken());

        array=new int[arraySize+1][arraySize+1];
        sumArray=new int[arraySize+1][arraySize+1];

        for(int i=1;i<=arraySize;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=arraySize;j++){
                array[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       for(int i=1;i<=arraySize;i++){
           for(int j=1;j<=arraySize;j++){
               sumArray[i][j]=sumArray[i-1][j]+sumArray[i][j-1]-sumArray[i-1][j-1]+array[i][j];
           }
       }
        
       for(int i=0;i<qSize;i++){
           st=new StringTokenizer(br.readLine());
           int x1=Integer.parseInt(st.nextToken());
           int y1=Integer.parseInt(st.nextToken());
           int x2=Integer.parseInt(st.nextToken());
           int y2=Integer.parseInt(st.nextToken());
           answer(x1,y1,x2,y2);
       }






    }
    public static void answer(int x1,int y1,int x2,int y2){
        System.out.println(sumArray[x2][y2]-sumArray[x1-1][y2]-sumArray[x2][y1-1]+sumArray[x1-1][y1-1]);
    }
}
