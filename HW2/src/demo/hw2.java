package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class hw2 {
    public static void main(String[] argv) {

        Scanner s = new Scanner(System.in);
        int caseNum = 1;
        
        while(s.hasNextLine()){
            int target = Integer.parseInt(s.nextLine());
            int[] startPosArr = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();  
            int[] speedArr = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();  
            if(s.hasNextLine()) s.nextLine();
            
            ArrayList<Car> cars = new ArrayList<>();
            for(int i=0; i<startPosArr.length; i++){
                cars.add(new Car(startPosArr[i], speedArr[i]));
            }
            Collections.sort(cars, (o1, o2) -> o1.pos - o2.pos);
            
            int result = 0;
            while(cars.size() > 0){
                for(int i=0; i<cars.size(); i++){
                    Car curCar = cars.get(i);
                    curCar.pos += curCar.speed;
                }

                ArrayList<Car> temp = new ArrayList<>();
                for(int i=0; i<cars.size()-1; i++){
                    Car curCar = cars.get(i);
                    Car nextCar = cars.get(i+1);
                    if(curCar.pos < nextCar.pos){
                        temp.add(curCar);
                    }
                }
                temp.add(cars.get(cars.size()-1));
                cars = temp;
                temp = new ArrayList<>();

                for(int i=0; i<cars.size(); i++){
                    Car curCar = cars.get(i);
                    if(curCar.pos < target){
                        temp.add(curCar);
                    }
                    else{
                        result++;
                    }
                }

                cars = temp;
            }
            System.out.printf("Case %d: %s.\n", caseNum++, result);
        }

        s.close();
    }
}

class Car{
    public int pos;
    public int speed;

    public Car(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }
}