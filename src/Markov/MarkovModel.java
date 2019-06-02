package Markov;

import bca.util.*;
import java.util.Arrays;
import java.util.Random;
import java.lang.IllegalArgumentException;


public class MarkovModel {
    private static final int ASCII = 128;
    private int order;
    private BCAMapBaseline<BCAMapBaseline<Integer>> model = new BCAMapBaseline<>();
    //BCAArra

    //creates a Markov model of order k for the specified text
    public MarkovModel(String text, int k){
        this.order = k;
        text += text.substring(0, k);
        for(int i=0;i<text.length()-k;i++){
            String str = text.substring(i, i+k);
            String letterAfter = text.substring(i+k, i+k+1);
            if(model.containsKey(str)){
                BCAMapBaseline<Integer> innerMap = model.get(str);
                if(innerMap.containsKey(letterAfter))
                    innerMap.put(letterAfter, innerMap.get(letterAfter) + 1);
                else
                    innerMap.put(letterAfter, 1);
            }
            else{
                BCAMapBaseline newMap = new BCAMapBaseline();
                newMap.put(letterAfter, 1);
                model.put(str, newMap);
            }

        }
    }


    // returns the order k of this Markov model
    public int order(){
        return order;
    }

    // returns a string representation of the Markov model (as described below)
    public String toString(){
        String ret = "";
        BCAMapBaseline<Integer> innerMap;
        for(String i : model.keys()){
            ret += i + ": ";
            innerMap = model.get(i);
            for(String j : innerMap.keys()){
                ret += j + " ";
                ret += innerMap.get(j) + " ";
            }
            ret +="\n";
        }

        return ret;
    }

    // returns the number of times the specified kgram appears in the text
    // throws java.lang.IllegalArgumentException if kgram not of length k
    public int freq(String kgram){
        if(kgram.length() != order)
            throw new IllegalArgumentException();
        if(!Arrays.asList(model.keys()).contains(kgram))
            return 0;
        BCAMapBaseline<Integer> innerMap = model.get(kgram);
        int total = 0;
        for(String i: innerMap.keys()){
            total += innerMap.get(i);
        }

        return total;
    }

    // returns the number of times the character c follows the specified
    // kgram in the text
    // throws java.lang.IllegalArgumentException if kgram not of length k
    // or if c is not an ASCII character.
    public int freq(String kgram, char c){
        if(kgram.length()!=order  || c > 127)
            throw new IllegalArgumentException();
        return model.get(kgram).getOrDefault(Character.toString(c), 0);
    }

    // returns a random character that follows the specified kgram in the text,
    // chosen with weight proportional to the number of times that character
    // follows the specified kgram in the text
    // if the kgram is not of length k OR does not appear in the text, throw a
    // java.lang.IllegalArgumentException.
    public char random(String kgram){
        if(kgram.length() != order || !Arrays.asList(model.keys()).contains(kgram))
            throw new IllegalArgumentException();
        BCAMapBaseline<Integer> innerMap = model.get(kgram);
        BCAArrayList<String> vals = new BCAArrayList<>();
        for(String i:innerMap.keys()){
            for(int j=0;j<innerMap.get(i);j++){
                vals.add(i);
            }
        }
        Random rand = new Random();
        return vals.get(rand.nextInt(vals.size())).charAt(0);


    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
      String text1 = "banana";
      System.out.println("Source text: " + text1);
      MarkovModel model1 = new MarkovModel(text1, 2);
      System.out.println("model's toString():");
      System.out.println(model1.toString());
      System.out.println("freq(\"an\", 'a')    = " + model1.freq("an", 'a'));
      System.out.println("freq(\"na\", 'b')    = " + model1.freq("na", 'b'));
      System.out.println("freq(\"na\", 'a')    = " + model1.freq("na", 'a'));
      System.out.println("freq(\"na\")         = " + model1.freq("na"));
      System.out.println();

      String text2 = "na na na na hey hey hey goodbye";
      System.out.println("Source text: " + text2);
      MarkovModel model2 = new MarkovModel(text2, 3);
      System.out.println("model's toString():");
      System.out.println(model2.toString());
      System.out.println("freq(\"na \", 'n')   = " + model2.freq("na ", 'n'));
      System.out.println("freq(\"na \", 'h')   = " + model2.freq("na ", 'h'));
      System.out.println("freq(\"na \")        = " + model2.freq("na "));
      System.out.println("freq(\"hey\")        = " + model2.freq("hey"));
      System.out.println();

      String text3 = "one fish two fish red fish blue fish";
      System.out.println("Source text: " + text3);
      MarkovModel model3 = new MarkovModel(text3, 4);
      System.out.println("model's toString():");
      System.out.println(model3.toString());
      System.out.println("freq(\"ish \", 'r')  = " + model3.freq("ish ", 'r'));
      System.out.println("freq(\"ish \", 'x')  = " + model3.freq("ish ", 'x'));
      System.out.println("freq(\"ish \")       = " + model3.freq("ish "));
      System.out.println("freq(\"tuna\")       = " + model3.freq("tuna"));

      // Create additional tests!
    }

}
