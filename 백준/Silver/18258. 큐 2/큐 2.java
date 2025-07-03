import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static class MyQueue{
       LinkedList<Integer> queue;

        MyQueue(){
            this.queue=new LinkedList<>();
        }

        void push(int data){
            queue.add(data);
        }

        int pop(){
            if(queue.isEmpty()){
                return -1;
            }
            int size=queue.size();
            return queue.remove(0);
        }

        int size(){
            return queue.size();
        }

        int front(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(0);
        }

        int back(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(queue.size()-1);
        }

        int empty(){
            if(queue.isEmpty()){
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        MyQueue q=new MyQueue();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String input=st.nextToken();
            if(input.equals("push")){
                int num=Integer.parseInt(st.nextToken());
                q.push(num);
            }
            else{
                switch(input){
                    case "pop":
                        sb.append(q.pop()).append("\n");
                        break;
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(q.empty()).append("\n");
                        break;
                    case "front":
                        sb.append(q.front()).append("\n");
                        break;
                    case "back":
                        sb.append(q.back()).append("\n");
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}
