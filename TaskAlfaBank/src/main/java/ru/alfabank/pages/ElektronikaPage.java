package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElektronikaPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Мобильные телефоны')] ")
    private WebElement mobileLink;

    public WebElement getMobileLink() {
        return mobileLink;
    }

    @Step("5) Выбрать раздел Мобильные телефоны")
    public MobilePage submitMobileLink(){
        getMobileLink().click();
        return new MobilePage(driver);
    }

    public ElektronikaPage(WebDriver driver) {
        super(driver);
    }
}
