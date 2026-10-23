import java.util.*;
import java.io.*;

class Solution {
    static final int[] dr = new int[]{-1,0,1,0};
    static final int[] dc = new int[]{0,1,0,-1};
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static int startRow ;
    static int startCol;
    static int[][] arr;
    static final int SIZE= 4;
    static Map<Integer,List<int[]>> cards;
    static Set<Integer> existed;
    static List<Integer> cardList;
    static boolean[] selected;//카드 조합 생성에서 선택된 카드 표기
    static List<int[]> combinations;
    static int cardCount;
    static int answer;
    
    static int[][] copy(){
        int[][] map = new int[SIZE][SIZE];
        
        for(int i=0;i<SIZE;i++){
            map[i]=arr[i].clone();
        }
        
        return map;
    }
    static boolean isValid(int row,int col){
        return row>=0 && row<SIZE && col>=0 && col<SIZE;
    }
    
    static void init(int[][] board){
        cards = new HashMap<>();    
        arr = new int[SIZE][SIZE];
        existed = new HashSet<>();
        combinations = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        
        for(int cardNum=1;cardNum<=6;cardNum++){
            cards.put(cardNum, new ArrayList<>());
        }
        
        
        for(int i=0;i<SIZE;i++){
            arr[i] = board[i].clone();
        }
        
        for(int row=0;row<SIZE;row++){
            for(int col=0;col<SIZE;col++){
                if(arr[row][col]!=0){
                    cards.get(arr[row][col]).add(new int[]{row,col});
                    existed.add(arr[row][col]);
                }
            }
        }
        
        cardCount = existed.size();
        cardList=new ArrayList<>(existed);
    }
    
    
    static void makeCombination(int cnt,int[] cardArr,boolean[] selected){
        if(cnt==cardCount){
            combinations.add(cardArr.clone());
            return;
        }
        
        
        for(int next:cardList){
            if(selected[next]) continue;
            
            selected[next]=true;
            cardArr[cnt]=next;
            makeCombination(cnt+1,cardArr,selected);
            selected[next]=false;
        }
        
    }
    static int[] ctrlMove(int[][] map,int[] start,int dir){
        int[] pos = new int[2];
        int r=start[0];
        int c = start[1];
        
        while(true){
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            
            if(!isValid(nr,nc)){
                break;
            }
            
            r=nr;
            c=nc;
        
            if(map[r][c]!=0){
                break;
            }
        }
        
        return new int[]{r,c};
    }
    static int bfs(int[] start,int[] end,int[][] map){
        int cnt=0;
        int[][] dist = new int[SIZE][SIZE];
        
        for(int i=0;i<SIZE;i++){
            Arrays.fill(dist[i],-1);
        }
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        dist[start[0]][start[1]]=0;
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            if(now[0]==end[0] && now[1]==end[1]){
                return dist[end[0]][end[1]];
            }
            
            for(int d=0;d<4;d++){
                int nr=now[0]+dr[d];
                int nc = now[1]+dc[d];
                
                if(isValid(nr,nc) && dist[nr][nc]==-1){
                    dist[nr][nc]=dist[now[0]][now[1]]+1;
                    dq.offer(new int[]{nr,nc});
                }
                
                
                int[] ctrl = ctrlMove(map,now,d);
                
                if(dist[ctrl[0]][ctrl[1]]==-1){
                    dist[ctrl[0]][ctrl[1]] = dist[now[0]][now[1]]+1;
                    dq.offer(ctrl);   
                }
            }
        }
        
        return -1;
    }
    
    static void operation(int r,int c){
        for(int[] cardOrder: combinations){
            dfs(cardOrder,0,0,copy(),new int[]{r,c});
        }
    }
    
    static void dfs(
        int[] cardOrder,
        int total,
        int idx,
        int[][] map,
        int[] start
    ){
        if(total>=answer) return;
        
        if(cardCount==idx){
            answer = Math.min(total,answer);
            
            return;
        }
        
        int cardNum = cardOrder[idx];
        
        int[] pos1 = cards.get(cardNum).get(0);
        int[] pos2 = cards.get(cardNum).get(1);
        
        //start -> pos1 -> pos2
        int dist1 = bfs(start,pos1,map) + bfs(pos1,pos2,map) + 2;
        //start -> pos2 -> pos1
        int dist2 = bfs(start,pos2,map) + bfs(pos2,pos1,map) + 2;
        
        //카드 삭제
        map[pos1[0]][pos1[1]]=0;
        map[pos2[0]][pos2[1]]=0;
        
        //pos2로 끝난 경우
        dfs(cardOrder,total+dist1,idx+1,map,pos2);
        
        //pos1로 끝난 경우
        dfs(cardOrder,total+dist2,idx+1,map,pos1);
        
        map[pos1[0]][pos1[1]]=cardNum;
        map[pos2[0]][pos2[1]]=cardNum;
    }
    public int solution(int[][] board, int r, int c) {
        init(board);
        makeCombination(0,new int[cardCount],new boolean[7]);
        operation(r,c);
        
        return answer;
    }
}