package ru.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.toLowerCase;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {
    public String reverseStroka(String strokaBefore){
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
        //return strokaAfter.equalsIgnoreCase(strokaMiddle);
        //assertEquals(strokaAfter.toLowerCase(),strokaMiddle.toLowerCase());
        return strokaAfter;
    }

}
