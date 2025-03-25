package demo;
import java.util.Scanner;

public class hw2 {
    public static boolean isValidGroup(int[] lineOfBoard){
        boolean[] haveSeen = new boolean[10];
        for(int num : lineOfBoard){
            if(haveSeen[num]) return false;
            haveSeen[num] = true;
        }
        return true;
    }

    public static boolean checkSudoku(int[][] board){
        for(int i=0; i<9; i++){
            if(isValidGroup(board[i]) == false){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            int[] tempGroup = new int[9];
            for(int j=0; j<9; j++){
                tempGroup[j] = board[j][i];
            }
            if(isValidGroup(tempGroup) == false){
                return false;
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int[] tempGroup = new int[9];
                int index = 0;
                for(int k=i*3; k<i*3+3; k++){
                    for(int l=j*3; l<j*3+3;l++){
                        tempGroup[index++] = board[k][l];
                    }
                }
                if(isValidGroup(tempGroup) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] argv) {
        Scanner s = new Scanner(System.in);
        int caseNum = 1;
        while(s.hasNextLine()){
            int[][] board = new int[9][9];
            for(int i=0; i<9; i++){
                String line = s.nextLine();
                for(int j=0; j<9; j++){
                    board[i][j] = line.charAt(j) - '0';
                }
            }
            if(s.hasNextLine()) s.nextLine();
            
            String result = "True";
            if(!checkSudoku(board)){
                result = "False";
            }
            System.out.printf("Case %d: %s.\n", caseNum, result);

            caseNum++;
        }
        
        s.close();
    }
}