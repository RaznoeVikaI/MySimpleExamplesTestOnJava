package ru.alfabank;

import org.junit.Test;
import ru.alfabank.data.TestDataForFirstTest;
import ru.alfabank.pages.*;

public class FirstTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        //Класс с тестовыми данными
        TestDataForFirstTest testDataForFirstTest = new TestDataForFirstTest();

        MainYandexPage mainYandexPage = new MainYandexPage(driver);
        MarketChoicePage marketChoicePage = mainYandexPage.submitMarketLink();
        ElektronikaPage elektronikaPage = marketChoicePage.submitElektronikaLink();
        MobilePage mobilePage = elektronikaPage.submitMobileLink();
        MobileChoicePage mobileChoicePage = mobilePage.submitAllFiltersButton();
        mobileChoicePage.selectSearchOptions(
                testDataForFirstTest.getPriceFrom()
        );
        ResultChoiceMobilePage resultChoiceMobilePage = mobileChoicePage.submitShowSuitableButton();
        resultChoiceMobilePage.checkCountShowElement();
        SearchResultFirstFoundElementPage searchResultFirstFoundElementPage = resultChoiceMobilePage.titleFirstElement();
    }
}
