package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultChoiceMobilePage extends AbstractPage {

    //Кол-во найденных элементов
    private int countFoundElement = driver.findElements(By.xpath("//div[contains(@data-id,'model')]")).size();

    @FindBy(xpath = "//*[@id='header-search']")
    private WebElement searchStringInput;

    @FindBy(xpath = "//span[@class='button2__text']")
    private WebElement searchButton;

    //Первый найденный элемент
    @FindBy(xpath = "//div[contains(@class,'title')]/a[1]")
    private WebElement firstFoundElement;

    //Элемент для пункта 13)
    @FindBy(css = "h1.title > a:nth-child(1)")
    private WebElement firstElement;

    public WebElement getFirstElement() {
        return firstElement;
    }


    public void setFirstFoundElement(WebElement firstFoundElement) {
        this.firstFoundElement = firstFoundElement;
    }

    public int getCountFoundElement() {
        return countFoundElement;
    }

    public WebElement getFirstFoundElement() {
        return firstFoundElement;
    }

    public WebElement getSearchStringInput() {
        return searchStringInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    @Step("10) Проверить, что элементов на странице 12.")
    public void checkCountShowElement() throws InterruptedException {
        Assert.assertEquals(48,getCountFoundElement());
    }

    @Step("11) Запомнить первый элемент в списке. 12) В поисковую строку ввести запомненное значение")
    public SearchResultFirstFoundElementPage titleFirstElement(){
        setFirstFoundElement(getFirstFoundElement());
        getSearchStringInput().clear();
        getSearchStringInput().click();
        getSearchStringInput().sendKeys(getFirstFoundElement().getText());
        getSearchButton().click();
        return new SearchResultFirstFoundElementPage(driver);
    }

    public ResultChoiceMobilePage(WebDriver driver) {
        super(driver);
    }
}
