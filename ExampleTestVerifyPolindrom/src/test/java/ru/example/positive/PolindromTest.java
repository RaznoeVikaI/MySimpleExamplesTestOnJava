package ru.example.positive;

import org.testng.annotations.Test;
import ru.example.BaseTest;

public class PolindromTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void inputEmptyStroka(){
        baseTest.verifyStroka("");
    }

    @Test
    public void inputOneLetter(){
        baseTest.verifyStroka("v");
    }

    @Test
    public void inputOneNumeral(){
        baseTest.verifyStroka("5");
    }

}
