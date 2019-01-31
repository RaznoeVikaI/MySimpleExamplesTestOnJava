package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePage extends AbstractPage {

    // 'Все фильтры'
    @FindBy(css = "._28j8Lq95ZZ")
    private WebElement allFiltersButton;

    public WebElement getAllFiltersButton() {
        return allFiltersButton;
    }

    @Step("6) Перейти в расширенный поиск")
    public MobileChoicePage submitAllFiltersButton(){
        getAllFiltersButton().click();
        return new MobileChoicePage(driver);
    }



    public MobilePage(WebDriver driver) {
        super(driver);
    }
}
