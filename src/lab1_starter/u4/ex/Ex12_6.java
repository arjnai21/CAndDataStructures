package lab1_starter.u4.ex;

import java.util.Arrays;

public class Ex12_6{
    /**
     * Main method
     */
    public static void main(String[] args){
        try{
            if(hexToDecimal("F53A")==62778)
                System.out.println("Passed 1");
            else
                System.out.println("Failed 1: Incorrect conversion result.");
        }catch(NumberFormatException ex){
            System.out.println("Failed 1: Unexpected exception.");
        }
        try{
            if(hexToDecimal("ba")==186)
                System.out.println("Passed 2");
            else
                System.out.println("Failed 2: Incorrect conversion result.");

        }catch(NumberFormatException ex){
            System.out.println("Failed 2: Unexpected exception.");
        }

        try{
            hexToDecimal("G3");
            System.out.println("Failed 3: Did not catch illegal format.");
        }catch(NumberFormatException ex){
            System.out.println("Passed 3.");
        }

        try{
            hexToDecimal("g9");
            System.out.println("Failed 4: Did not catch illegal format.");
        }catch(NumberFormatException ex){
            System.out.println("Passed 4.");
        }

        try{
            hexToDecimal("2*");
            System.out.println("Failed 5: Did not catch illegal format.");
        }catch(NumberFormatException ex){
            System.out.println("Passed 5.");
        }

        try{
            hexToDecimal(">5");
            System.out.println("Failed 6: Did not catch illegal format.");
        }catch(NumberFormatException ex){
            System.out.println("Passed 6.");
        }
    }


    public static int hexToDecimal(String hex){
        int decimalValue=0;
        char[] hexChars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        for(int i=0;i<hex.length();i++){
            char hexChar=hex.charAt(i);
            if(!(hexChar >= 'A'&&hexChar<='F'||hexChar >= '0'&&hexChar<='9'||hexChar >= 'a'&&hexChar<='f'))
                throw new NumberFormatException();
            decimalValue=decimalValue*16+hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    public static int hexCharToDecimal(char ch){
        if(ch >= 'A'&&ch<='F')
            return 10+ch-'A';
        else if(ch >= 'a'&&ch<='f')
            return 10+ch-'a';
        else // ch is '0', '1', ..., or '9'
            return ch-'0';
    }
}
