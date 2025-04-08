package demo;
import java.util.Scanner;

public class hw3 {
    public static void main(String[] argv) {
        Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();
        s.close();
        
        int result = 0;
        for(int center = 0; center < inputStr.length() * 2; center++){
            int left = center / 2;
            int right = left + (center % 2);
            while(left >= 0 && right < inputStr.length() && inputStr.charAt(left) == inputStr.charAt(right)){
                result++;
                left--;
                right++;               
            }
        }

        System.out.println(result);
    }
}