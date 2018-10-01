package ru.lesson;

import io.qameta.allure.Description;
import org.junit.Test;
import ru.lesson.data.TestDataForFirstTest;
import ru.lesson.pages.*;

public class FirstTest extends BaseTest {

    @Test
    @Description("Проверка поиска ноутбуков с параметрами поиска")
    public void test(){
        //Класс с тестовыми данными
        TestDataForFirstTest testDataForFirstTest = new TestDataForFirstTest();

        MainYandexPage mainYandexPage = new MainYandexPage(driver);
        //assertEquals("http://blazedemo.com/purchase.php", getDriver().getCurrentUrl());
        MarketChoicePage marketChoicePage = mainYandexPage.submitMarketLink();
        ComputerTechnikPage computerTechnikPage = marketChoicePage.submitComputersLink();
        LaptopsChoicePage laptopsChoicePage = computerTechnikPage.submitLaptopsLink();
        //ЗАПОЛНИТЬ ЛЮБЫМИ ДАННЫМИ ПОЛЯ - БЕРУТСЯ ИЗ КЛАССА TestDataForFirstTest
        laptopsChoicePage.inputTextIntoInput(
                testDataForFirstTest.getPriceFrom(),
                testDataForFirstTest.getPriceTo()
        );
        //laptopsChoicePage.chouseCountDisplayedNotebooksOnPage();
        //laptopsChoicePage.selectIndex();
        laptopsChoicePage.chouseCountDisplayedNotebooksOnPage();

        SelectionResultsPage selectionResultsPage = laptopsChoicePage.assertResults();
        selectionResultsPage.countFindsNotebooksOnPage();

    }
}
