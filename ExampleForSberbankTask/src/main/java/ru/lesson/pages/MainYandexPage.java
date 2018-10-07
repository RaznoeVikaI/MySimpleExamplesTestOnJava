package ru.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainYandexPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-id='market']")
    private WebElement marketLink;

    public WebElement getMarketLink() {
        return marketLink;
    }


    @Step("Переходим на страницу Маркет")
    public MarketChoicePage submitMarketLink(){
        getMarketLink().click();
        return new MarketChoicePage(driver);
    }

    public MainYandexPage(WebDriver driver) {
        super(driver);
    }
}
