package ru.example.negative;

import org.testng.annotations.Test;
import ru.example.BaseTest;

import static org.testng.Assert.assertNotEquals;

public class PolindromTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void inputSpecialSymbols(){
        //baseTest.reverseStroka(")!");
        assertNotEquals(")!",baseTest.reverseStroka(")!"));
    }

    @Test
    public void inputStrokaOnEnglish(){
        //baseTest.reverseStroka("numeral");
        assertNotEquals("numeral",baseTest.reverseStroka("numeral"));
    }

    @Test
    public void inputStrokaOnJapane(){
        //baseTest.reverseStroka("数字");
        assertNotEquals("数字",baseTest.reverseStroka("数字"));
    }

    @Test
    public void inputStroka(){
        //baseTest.reverseStroka("Madam, I'm Adam!");
        //baseTest.reverseStroka("Мама");
        assertNotEquals("Мама",baseTest.reverseStroka("Мама"));
    }
}