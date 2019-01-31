package ru.alfabank;


import org.junit.Test;
import ru.alfabank.data.TestDataForSecondTest;
import ru.alfabank.pages.*;

public class SecondTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        //Класс с тестовыми данными
        TestDataForSecondTest testDataForSecondTest = new TestDataForSecondTest();

        MainYandexPage mainYandexPage = new MainYandexPage(driver);
        MarketChoicePage marketChoicePage = mainYandexPage.submitMarketLink();
        ElektronikaPage elektronikaPage = marketChoicePage.submitElektronikaLink();
        HeadphonesPage headphonesPage = elektronikaPage.submitHeadphonesLink();
        HeadphonesChoicePage headphonesChoicePage = headphonesPage.submitAllFiltersButton();
        headphonesChoicePage.selectSearchOptions(
                testDataForSecondTest.getPriceFrom()
        );
        ResultChoiceHeadphonesPage resultChoiceHeadphonesPage = headphonesChoicePage.submitShowSuitableButton();
        resultChoiceHeadphonesPage.checkCountShowElement();
        SearchResultFirstFoundElementPage searchResultFirstFoundElementPage = resultChoiceHeadphonesPage.titleFirstElement();
    }
}
