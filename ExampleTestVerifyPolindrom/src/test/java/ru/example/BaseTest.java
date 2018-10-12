package ru.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseTest {
    public boolean verifyStroka(String strokaBefore){
        String strokaAfter="";
        String strokaMiddle=strokaBefore.replace(" ","");
        char[] charBefore =strokaMiddle.toCharArray();
        char[] charAfter=new char[charBefore.length];
        for ( int i =charBefore.length-1; i>= 0;){
            //System.out.println(charBefore[i]);
            for(int j=0;j<charAfter.length; j++){

                charAfter[j]=charBefore[i]; i--;

                strokaAfter+=charAfter[j];

            }

        }
        System.out.println(strokaAfter);
        System.out.println(strokaMiddle);
        return strokaAfter.equalsIgnoreCase(strokaMiddle);
    }

}
