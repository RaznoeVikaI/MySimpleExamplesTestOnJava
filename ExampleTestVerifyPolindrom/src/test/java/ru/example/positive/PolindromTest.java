package ru.example.positive;

import org.testng.annotations.Test;
import ru.example.BaseTest;

public class PolindromTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void inputEmptyStroka(){
        baseTest.reverseStroka("");
    }

    @Test
    public void inputOneLetter(){
        baseTest.reverseStroka("v");
    }

    @Test
    public void inputOneNumeral(){
        baseTest.reverseStroka("5");
    }

}
