import java.util.ArrayDeque;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer>dq=new ArrayDeque<>();
        ArrayList<Integer> answer=new ArrayList<>();
        
        //다음 수가 현재 수보다 작거나 같으면 담고 사이즈 재기
        for(int i=0;i<progresses.length;i++){
            //날짜 계산
            int day=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
            if(!dq.isEmpty() && dq.getFirst()<day){
                answer.add(dq.size());
                dq.clear();
            }
            dq.addLast(day);
            }
         answer.add(dq.size());
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        }
    }
