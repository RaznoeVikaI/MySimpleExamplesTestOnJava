package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketChoicePage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement elektronikaLink;

    public WebElement getElektronikaLink() {
        return elektronikaLink;
    }

    @Step("4) Выбрать раздел Электроника")
    public ElektronikaPage submitElektronikaLink(){
        getElektronikaLink().click();
        return new ElektronikaPage(driver);
    }

    public MarketChoicePage(WebDriver driver) {
        super(driver);
    }
}
