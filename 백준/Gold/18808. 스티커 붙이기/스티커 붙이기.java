import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Sticker{
        int row;
        int col;
        int[][] arr;
        public Sticker(int row,int col,int[][]arr){
            this.row=row;
            this.col=col;
            this.arr=arr;
        }
    }
    private static int[][] notebook;
    private static int N,M,K;
    private static StringTokenizer st;
    private static int result=0;
    private static void rotate(Sticker sticker) {
        int row = sticker.arr.length;
        int col = sticker.arr[0].length;
        int[][] rotateArray = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                rotateArray[i][j] = sticker.arr[row - 1 - j][i];
            }
        }
        sticker.arr = rotateArray;
        sticker.row = col;
        sticker.col = row;
    }

    //스티커 붙은 칸 수 출력
    private static void getTotalSticker(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(notebook[i][j]==1)
                    result++;
            }
        }
    }
    //스티커 붙이기
    private static void putOnSticker(Sticker sticker,int startRow,int startCol){
        int[][] arr=sticker.arr;
        for(int i=startRow;i<sticker.row+startRow;i++){
            for(int j=startCol;j<sticker.col+startCol;j++){
                if(arr[i-startRow][j-startCol]==1){
                    notebook[i][j]=1;
                }
            }
        }
    }
    //스티커 범위 유효성
    private static boolean isValid(Sticker sticker,int startRow,int startCol){
        //sticker 범위 체크
        if(startRow + sticker.row>N || startCol+sticker.col>M)
            return false;

        for(int i=0;i<sticker.row;i++){
            for(int j=0;j<sticker.col;j++){
                if(sticker.arr[i][j]==1 && notebook[startRow+i][startCol+j]==1)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        notebook=new int[N][M];

        int[][] arr;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int row=Integer.parseInt(st.nextToken());
            int col=Integer.parseInt(st.nextToken());
            arr=new int[row][col];

            for(int j=0;j<row;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<col;k++){
                    arr[j][k]=Integer.parseInt(st.nextToken());
                }
            }
            Sticker sticker=new Sticker(row,col,arr);

            for(int r=0;r<4;r++){
                boolean attached=false;
                for(int x=0;x<=N-sticker.row;x++){
                    for(int y=0;y<=M-sticker.col;y++){
                        if(isValid(sticker,x,y)){
                            putOnSticker(sticker,x,y);
                            attached=true;
                            break;
                        }
                    }
                    if(attached)
                        break;
                }
                if(attached) break;
                rotate(sticker);
            }

        }


        getTotalSticker();
        System.out.print(result);
    }
}
