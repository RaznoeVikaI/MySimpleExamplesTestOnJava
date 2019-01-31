package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElektronikaPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Наушники и Bluetooth-гарнитуры')] ")
    private WebElement headphonesLink;

    public WebElement getHeadphonesLink() {
        return headphonesLink;
    }

    @Step("5) Выбрать раздел Наушники.")
    public HeadphonesPage submitHeadphonesLink(){
        getHeadphonesLink().click();
        return new HeadphonesPage(driver);
    }

    public ElektronikaPage(WebDriver driver) {
        super(driver);
    }
}
