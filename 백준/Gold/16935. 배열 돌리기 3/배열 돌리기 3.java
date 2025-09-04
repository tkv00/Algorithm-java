import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int N,M,R;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[] order;
    private static ArrayList<int[]> initArr;

    /**
     * 초기화 메소드
     * @throws IOException
     */
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        initArr=new ArrayList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int[] k=new int[M];
            for (int j = 0; j < M; j++) {
                k[j]=Integer.parseInt(st.nextToken());
            }
            initArr.add(k);
        }

        order=new int[R];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<R;i++){
            order[i]=Integer.parseInt(st.nextToken());
        }

        sb=new StringBuilder();
    }

    /**
     * 상하 반전
     */
    private static ArrayList<int[]> operation_1(ArrayList<int[]> arr,int row,int col){
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=row-1;i>=0;i--){
            list.add(arr.get(i));
        }
        return list;
    }

    /**
     * 좌우 반전
     */
    private static ArrayList<int[]> operation_2(ArrayList<int[]> arr,int row,int col){
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<row;i++){
            int[]k=new int[col];
            for(int j=0;j<col;j++){
                k[j]=arr.get(i)[col-j-1];
            }
            list.add(k);
        }
        return list;
    }

    /**
     * 오른쪽 90도 회전.
     */
    private static ArrayList<int[]> operation_3(ArrayList<int[]> arr,int row,int col){
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<col;i++){
            int[]k=new int[row];
            for(int j=0;j<row;j++){
                k[j]=arr.get(row-1-j)[i];
            }
            list.add(k);
        }
        return list;
    }


    /**
     * 왼쪽 90도 회전
     */
    private static  ArrayList<int[]> operation_4(ArrayList<int[]> arr,int row,int col){
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<col;i++){
            int[] k=new int[row];
            for(int j=0;j<row;j++) {
                k[j] = arr.get(j)[col - 1 - i];
            }
            list.add(k);
        }
        return list;
    }

    /**
     * 5번 연산.
     */
    private static ArrayList<int[]> operation_5(ArrayList<int[]> arr,int row,int col){
        int[][] group_1=new int[row/2][col/2];
        int[][] group_2=new int[row/2][col/2];
        int[][] group_3=new int[row/2][col/2];
        int[][] group_4=new int[row/2][col/2];

        ArrayList<int[]> list=new ArrayList<>();

        //insert
        for(int i=0;i<row/2;i++){
            for(int j=0;j<col/2;j++){
                group_1[i][j]=arr.get(i)[j];
                group_2[i][j]=arr.get(i)[j+col/2];
                group_3[i][j]=arr.get(i+row/2)[j+col/2];
                group_4[i][j]=arr.get(i+row/2)[j];
            }
        }

        for(int i=0;i<row;i++){
            int[]k=new int[col];
            for(int j=0;j<col;j++){
                //4->1
                if(row/2>i && col/2>j) k[j]=group_4[i][j];
                //1->2
                else if(row/2>i && col/2<=j)k[j]=group_1[i][j-col/2];
                //2->3
                else if(row/2<=i && col/2<=j)k[j]=group_2[i-row/2][j-col/2];
                //3->4
                else k[j]=group_3[i-row/2][j];
            }
            list.add(k);
        }
        return list;
    }

    /**
     * 6번 연산.
     */
    private static ArrayList<int[]> operation_6(ArrayList<int[]> arr,int row,int col){
        int[][] group_1=new int[row/2][col/2];
        int[][] group_2=new int[row/2][col/2];
        int[][] group_3=new int[row/2][col/2];
        int[][] group_4=new int[row/2][col/2];

        ArrayList<int[]> list=new ArrayList<>();

        //insert
        for(int i=0;i<row/2;i++){
            for(int j=0;j<col/2;j++){
                group_1[i][j]=arr.get(i)[j];
                group_2[i][j]=arr.get(i)[j+col/2];
                group_3[i][j]=arr.get(i+row/2)[j+col/2];
                group_4[i][j]=arr.get(i+row/2)[j];
            }
        }

        for(int i=0;i<row;i++){
            int[]k=new int[col];
            for(int j=0;j<col;j++){
                //2->1
                if(row/2>i && col/2>j) k[j]=group_2[i][j];
                //3->2
                else if(row/2>i && col/2<=j)k[j]=group_3[i][j-col/2];
                //4->3
                else if(row/2<=i && col/2<=j)k[j]=group_4[i-row/2][j-col/2];
                //1->4
                else k[j]=group_1[i-row/2][j];
            }
            list.add(k);
        }
        return list;
    }


    public static void main(String[] args) throws IOException {
        init();
        ArrayList<int[]> result=new ArrayList<>(initArr);
        
        for(int x:order){
            switch(x){
                case 1:
                    result=operation_1(result,result.size(),result.get(0).length);
                    break;
                case 2:
                    result=operation_2(result,result.size(),result.get(0).length);
                    break;
                case 3:
                    result=operation_3(result,result.size(),result.get(0).length);
                    break;
                case 4:
                    result=operation_4(result,result.size(),result.get(0).length);
                    break;
                case 5:
                    result=operation_5(result,result.size(),result.get(0).length);
                    break;
                case 6:
                    result=operation_6(result,result.size(),result.get(0).length);
                    break;

            }
        }

        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(0).length;j++){
                sb.append(result.get(i)[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
