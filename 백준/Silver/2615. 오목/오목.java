import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int row;
        int col;
        int color;
        int dir;

        Node(int row, int col, int dir, int color) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.color = color;
        }
    }

    private static boolean isValid(int row, int col) {
        if (row < 0 || row >= 19 || col < 0 || col >= 19)
            return false;
        return true;
    }

    private static int[][] map = new int[19][19];
    private static StringTokenizer st;
    private static int[] dRow = new int[]{0, 1, 1,-1};
    private static int[] dCol = new int[]{1, 0, 1,1};
    private static int cnt=0;

    private static void dfs(Node node) {
        cnt++;
        int newRow = node.row + dRow[node.dir];
        int newCol = node.col + dCol[node.dir];
        if (!isValid(newRow, newCol) || (map[newRow][newCol] != map[node.row][node.col]))
            return;
        dfs(new Node(newRow, newCol, node.dir, node.color));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    for (int k=0;k<4;k++){
                        cnt=0;
                        Node node=new Node(i,j,k,map[i][j]);

                        int prevRow=i-dRow[k];
                        int prevCol=j-dCol[k];

                        if(isValid(prevRow,prevCol) && (map[prevRow][prevCol]==map[i][j]))
                            continue;
                        dfs(node);

                        int nextRow=i+cnt*dRow[k];
                        int nextCol=j+cnt*dCol[k];

                        if (cnt==5 && (!isValid(nextRow,nextCol) || map[i][j]!=map[nextRow][nextCol])){
                            System.out.println(node.color);
                            System.out.println(i+1+" "+Integer.parseInt(String.valueOf(j+1)));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
