package ru.example.positive;

import org.testng.annotations.Test;
import ru.example.BaseTest;

public class PolindromTest {

    BaseTest baseTest = new BaseTest();


    @Test
    public void inputStroka(){
        //baseTest.verifyStroka("Madam, I'm Adam!");
        baseTest.verifyStroka("Мама");
    }

    @Test
    public void inputEmptyStroka(){
        baseTest.verifyStroka("");
    }

    @Test
    public void inputSpecialSymbols(){
        baseTest.verifyStroka(")!");
    }

    @Test
    public void inputOneLetter(){
        baseTest.verifyStroka("v");
    }

    @Test
    public void inputOneNumeral(){
        baseTest.verifyStroka("5");
    }

    @Test
    public void inputStrokaOnEnglish(){
        baseTest.verifyStroka(
                "numeral");
    }

    @Test
    public void inputStrokaOnJapane(){
        baseTest.verifyStroka(
                "数字"
        );
    }
}
