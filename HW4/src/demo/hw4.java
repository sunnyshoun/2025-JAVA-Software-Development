package demo;
import java.util.HashMap;
import java.util.Scanner;

public class hw4 {
    public static void main(String[] argv) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        for(int i=0; i<n; i++){
            nodeMap.put(s.nextInt(), s.nextInt());
        }
        s.close();

        int slow = 0, fast = 0;
        while (nodeMap.containsKey(slow) && nodeMap.containsKey(fast)) {
            slow = nodeMap.get(slow);
            fast = nodeMap.get(nodeMap.get(fast));
            if(slow == fast){
                int minVal = slow;
                int cur = nodeMap.get(slow);
                while(cur != slow){
                    if(cur < minVal) minVal = cur;
                    cur = nodeMap.get(cur);
                }
                System.out.println(minVal);
                return;
            }
        }
        System.out.println(-1);
    }
}