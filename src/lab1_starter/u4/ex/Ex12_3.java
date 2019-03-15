package lab1_starter.u4.ex;

import java.util.Scanner;

public class Ex12_3{
    public static void main(String[] args){
        int[] array = new int[100];
        for(int i=0;i<array.length;i++){
            array[i] = (int) (Math.random() * 100);

        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an index:");
        int ind = in.nextInt();
        try{
            System.out.println(ind + ": " + array[ind]);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Out of Bounds.");
        }
    }
}
