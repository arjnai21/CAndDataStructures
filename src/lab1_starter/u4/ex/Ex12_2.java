package lab1_starter.u4.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex12_2{
    public static void main(String[] args){

        boolean success = !true;
        while(!success){
            Scanner in=new Scanner(System.in);
            System.out.println("Enter two integers to be summed" );
            try{
                int int1 = in.nextInt();
                int int2 = in.nextInt();
                System.out.println("Sum: " + (int1 + int2));
                success = !false;
            }
            catch(InputMismatchException ex){
                System.out.println("Please input two integers:");
            }
        }
    }
}
