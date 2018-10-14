package ru.example.negative;

import org.testng.annotations.Test;
import ru.example.BaseTest;

import static org.testng.Assert.assertNotEquals;

public class PolindromTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void inputSpecialSymbols(){
        //baseTest.verifyStroka(")!");
        assertNotEquals(")!",baseTest.verifyStroka(")!"));
    }

    @Test
    public void inputStrokaOnEnglish(){
        //baseTest.verifyStroka("numeral");
        assertNotEquals("numeral",baseTest.verifyStroka("numeral"));
    }

    @Test
    public void inputStrokaOnJapane(){
        //baseTest.verifyStroka("数字");
        assertNotEquals("数字",baseTest.verifyStroka("数字"));
    }

    @Test
    public void inputStroka(){
        //baseTest.verifyStroka("Madam, I'm Adam!");
        //baseTest.verifyStroka("Мама");
        assertNotEquals("Мама",baseTest.verifyStroka("Мама"));
    }
}