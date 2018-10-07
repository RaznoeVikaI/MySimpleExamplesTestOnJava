package ru.lesson;

import io.qameta.allure.Description;
import org.junit.Test;
import ru.lesson.data.TestDataForYandexSearchMarketNotebooksTest;
import ru.lesson.pages.*;

public class YandexSearchMarketNotebooksTest extends BaseTest {

    @Test
    @Description("Проверка поиска ноутбуков с параметрами поиска")
    public void test() throws InterruptedException {
        //Класс с тестовыми данными
        TestDataForYandexSearchMarketNotebooksTest testDataForFirstTest = new TestDataForYandexSearchMarketNotebooksTest();

        MainYandexPage mainYandexPage = new MainYandexPage(driver);
        MarketChoicePage marketChoicePage = mainYandexPage.submitMarketLink();
        ComputerTechnikPage computerTechnikPage = marketChoicePage.submitComputersLink();
        LaptopsChoicePage laptopsChoicePage = computerTechnikPage.submitLaptopsLink();
        //ЗАПОЛНИТЬ ЛЮБЫМИ ДАННЫМИ ПОЛЯ - БЕРУТСЯ ИЗ КЛАССА TestDataForFirstTest
        laptopsChoicePage.inputTextIntoInput(
                testDataForFirstTest.getPriceFrom(),
                testDataForFirstTest.getPriceTo()
        );
        //Приделан костыль: Thread.sleep(7000);
        laptopsChoicePage.chouseCountDisplayedNotebooksOnPage();
    }
}