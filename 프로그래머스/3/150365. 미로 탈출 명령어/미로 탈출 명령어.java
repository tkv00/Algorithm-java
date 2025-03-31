import java.util.*;

class Solution {
    private static int rowS;
    private static int colS;
    private static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static String[] directions={"d","l","r","u"};
    private static int[] dr={1,0,0,-1};
    private static int[] dc={0,-1,1,0};
    //위치 유효성 검사
    private static boolean isValid(int row,int col){
        if(row<0 || col<0 || row>=rowS || col>=colS)
            return false;
        return true;
    }
    
    
    private static boolean distance(int endRow,int endCol,int row,int col,int k){
        if(Math.abs(endRow-row)+Math.abs(endCol-col)>k) 
            return false;
        return true;
    }
    
    //dfs작성
    private String dfs(Node node,int cnt,int k,String str,Node end){
        if(cnt>k) return null;
        
        if(!distance(end.row,end.col,node.row,node.col,k-cnt)) return null;
        
        //남은 횟수로 도달하지 못하는 경우
        if(cnt==k){
            //경로 도달
            if(end.row==node.row && end.col==node.col){
                return str;
            }else return null;
        }
        
        

        for(int i=0;i<4;i++){
            int newRow=node.row+dr[i];
            int newCol=node.col+dc[i];
            
            if(isValid(newRow,newCol)){
                String result=dfs(new Node(newRow,newCol),cnt+1,k,str+directions[i],end);
                if(result!=null) return result;
            }
        }
        return null;
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        rowS=n;
        colS=m;
        //출발 지점
        Node startNode=new Node(x-1,y-1);
        
        //도착 지점
        Node endNode=new Node(r-1,c-1);
        int dist=Math.abs(startNode.row-endNode.row)+Math.abs(startNode.col-endNode.col);
        
        if((k-dist)%2!=0 || dist>k) return "impossible";
        if(!distance(endNode.row,endNode.col,startNode.row,startNode.col,k)){
            return "impossible";
        }
        String str=dfs(startNode,0,k,"",endNode);
        if(str!=null) return str;
        return "impossible";
        
    }
}