package ru.lesson.pages;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import static org.junit.Assert.*;


public class LaptopsChoicePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='glpricefrom']")
    private WebElement priceFromInput;

    @FindBy(xpath = "//*[@id='glpriceto']")
    private WebElement priceToInput;

    @FindBy(xpath = "//div[@class='n-snippet-card2__title']")
    private int countFindNotebooksOnPage;


    public WebElement getPriceFromInput() {
        return priceFromInput;
    }

    public WebElement getPriceToInput() {
        return priceToInput;
    }

    public int getCountFindNotebooksOnPage() {
        return countFindNotebooksOnPage;
    }

    @Step("Проставляем параметры поиска нотубуков")
    public void inputTextIntoInput(String priceFrom, String priceTo){
        getPriceFromInput().clear();
        getPriceFromInput().sendKeys(priceFrom);
        getPriceToInput().clear();
        getPriceToInput().sendKeys(priceTo);
    }



    @Step("Нажимаем на кнопку 'Показать по ...'")
    public void chouseCountDisplayedNotebooksOnPage() throws InterruptedException {
        List<WebElement> temp = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        System.out.println(temp.size());
        WebElement selectElem = driver.findElement(By.xpath(".//*[@role='listbox']"));
        selectElem.click();
        WebElement element = driver.findElement(By.xpath("//span[@class='select__text' and text()='Показывать по 12']"));
        element.click();
        //Ксотыль
        Thread.sleep(7000);
        List<WebElement> countFindsNotebooks = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        //System.out.println(countFindsNotebooks.size());
        //return countFindsNotebooks.size();
        verifyCountDisplayedNotebooks(countFindsNotebooks.size());
    }

    @Step("Смотрим колличество найденных ноутубков после нажатиия кнопки 'Показать по ...'")
    public void verifyCountDisplayedNotebooks(int count){
        assertEquals(count,12);
    }

    public LaptopsChoicePage(WebDriver driver) {
        super(driver);
    }
}