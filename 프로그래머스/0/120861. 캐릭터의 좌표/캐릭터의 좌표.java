class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        //캐릭터의 좌표값 
        int x=0;int y=0;
        int idx=0;
        
        while(idx!=keyinput.length){
            String now=keyinput[idx];
            int moveX=0;
            int moveY=0;
            switch(now){
                case "up":
                    moveY=1;
                    break;
                case "down":
                    moveY=-1;
                    break;
                case "left":
                    moveX=-1;
                    break;
                case "right":
                    moveX=1;
                    break;
            }
            //범위 초과
            if(x+moveX <= board[0]/2 && x+moveX>=-board[0]/2 && 
               y+moveY<=board[1]/2 && y+moveY>=-board[1]/2) {
                   x+=moveX;
                y+=moveY;
            }
            idx+=1;
            
        }
        
        int[] answer = {x,y};
        return answer;
    }
}