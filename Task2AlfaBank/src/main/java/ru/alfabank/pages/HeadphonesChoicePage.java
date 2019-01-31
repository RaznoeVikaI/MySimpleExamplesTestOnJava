package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeadphonesChoicePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='glf-pricefrom-var']")
    private WebElement priceFromInput;

    @FindBy(xpath = "//*[contains(text(),'Beats')]")
    private WebElement firmaBeatsLabel;

    @FindBy(xpath = "//span[text()='Показать подходящие']")
    private WebElement showSuitable;

    public WebElement getShowSuitable() {
        return showSuitable;
    }

    public WebElement getPriceFromInput() {
        return priceFromInput;
    }

    public WebElement getFirmaBeatsLabel() {
        return firmaBeatsLabel;
    }

    @Step("7) Задать параметр поиска от 5000 рублей. 8) Выбрать производителя Beats.")
    public void selectSearchOptions(String priceFrom) throws InterruptedException {
        getPriceFromInput().clear();
        getPriceFromInput().sendKeys(priceFrom);
        getFirmaBeatsLabel().click();
    }

    @Step("9) Нажать кнопку Применить.")
    public ResultChoiceHeadphonesPage submitShowSuitableButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getShowSuitable());
        Actions actions = new Actions(driver);
        actions.moveToElement(getShowSuitable(),0,0);
        actions.click().build().perform();
        return new ResultChoiceHeadphonesPage(driver);
    }

    public HeadphonesChoicePage(WebDriver driver) {
        super(driver);
    }
}
