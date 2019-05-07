import bca.util.BCAArrayList;
import bca.util.BCAMapBaseline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest{
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String text="abaabbabcabxabyabyabyabijxfgfdbgsuer rgbreuigbfuidbihtgtuiwhtrui htriug huritghurighuihgiu guhreiughuitrghtruigh truigh rtuighturigh rutighuitgrhuitrgh utrihg truifh guitrg uitrhgutrihguitrhgtrujigh rtuifghutrigh truighuitrhg uirthguitg huihguierh guith guirh guitrhg uitrghuifthg ujigfh buih uti hbuih buihguifh ubijh gfuji hngji hgfuji hui hrgtiu hgui hgui hgui hg uirhgui ruig grui hugi hgfui hbgfjk hbvjk nbjk nfgj hgujfoinbjk hubfiv";
        BCAMapBaseline<BCAMapBaseline<Integer>> model=new BCAMapBaseline<>();
        text+=text.substring(0,2);
        for(int i=0;i<text.length()-2;i++){
            String searchStr=text.substring(i,i+2);
            if(model.containsKey(searchStr)){
                continue;
            }
            //BCAArrayList<String> allMatches = new BCAArrayList<String>();

            //https://stackoverflow.com/questions/5163785/how-do-i-get-the-last-character-of-a-string
            Matcher m=Pattern.compile(searchStr+"[ -~]").matcher(text);
            BCAMapBaseline<Integer> vals=new BCAMapBaseline<>();

            while(m.find()){
                String character=m.group().substring(m.group().length()-1);
                if(vals.containsKey(character)){
                    vals.put(character,vals.get(character)+1);

                }else{
                    vals.put(character,1);
                }

            }
            model.put(searchStr,vals);


        }
        System.out.println(System.currentTimeMillis() - startTime);
        //other algo
        startTime = System.currentTimeMillis();
        text="abaabbabcabxabyabyabyabijxfgfdbgsuer rgbreuigbfuidbihtgtuiwhtrui htriug huritghurighuihgiu guhreiughuitrghtruigh truigh rtuighturigh rutighuitgrhuitrgh utrihg truifh guitrg uitrhgutrihguitrhgtrujigh rtuifghutrigh truighuitrhg uirthguitg huihguierh guith guirh guitrhg uitrghuifthg ujigfh buih uti hbuih buihguifh ubijh gfuji hngji hgfuji hui hrgtiu hgui hgui hgui hg uirhgui ruig grui hugi hgfui hbgfjk hbvjk nbjk nfgj hgujfoinbjk hubfiv";
        model=new BCAMapBaseline<>();
        text+=text.substring(0,2);
        for(int i=0;i<text.length()-3;i++){
            String str = text.substring(i, i+2);
            String letterAfter = text.substring(i+2, i+3);
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

        System.out.println(System.currentTimeMillis() - startTime);

    }

}
