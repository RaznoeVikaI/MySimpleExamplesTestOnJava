package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MobileChoicePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='glf-pricefrom-var']")
    private WebElement priceFromInput;

    @FindBy(xpath = "//*[contains(text(),'Apple')]")
    private WebElement firmaAppleLabel;

    @FindBy(xpath = "//*[contains(text(),'Samsung')]")
    private WebElement firmaSamsungLabel;

    public WebElement getFirmaSamsungLabel() {
        return firmaSamsungLabel;
    }

    public WebElement getFirmaAppleLabel() {
        return firmaAppleLabel;
    }

    public WebElement getPriceFromInput() {
        return priceFromInput;
    }

    @Step("7) Задать параметр поиска от 20000 рублей. 8) Выбрать производителей Apple и Samsung ")
    public void selectSearchOptions(String priceFrom) throws InterruptedException {
        getPriceFromInput().clear();
        getPriceFromInput().sendKeys(priceFrom);
        getFirmaAppleLabel().click();
        getFirmaSamsungLabel().click();
    }

    @Step("9) Нажать кнопку Применить.")
    public ResultChoiceMobilePage submitShowSuitableButton(){
        WebElement element = driver.findElement(By.xpath("//span[text()='Показать подходящие']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Показать подходящие']")),0,0);
        actions.click().build().perform();
        return new ResultChoiceMobilePage(driver);
    }

    public MobileChoicePage(WebDriver driver) {
        super(driver);
    }
}
