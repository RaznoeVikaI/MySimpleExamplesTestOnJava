package ru.lesson.pages;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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


    public void chouseCountDisplayedNotebooksOnPage(){
        //By.xpath(".//*[@role='listbox']"
        //By.xpath(".//option[contains(text(),'Показывать по 12')]")
        //Кликает по выпадающему списку:"Показать по 12","Показать по 48"
        //--------------------------------------------------------------------
        List<WebElement> temp = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        System.out.println(temp.size());
        WebElement selectElem = driver.findElement(By.xpath(".//*[@role='listbox']"));
        selectElem.click();
        WebElement element = driver.findElement(By.xpath("//span[@class='select__text' and text()='Показывать по 12']"));
        element.click();
        WebElement element2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='n-snippet-card2__title']")));
        List<WebElement> temp2 = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        System.out.println(temp2.size());
    }

    public LaptopsChoicePage(WebDriver driver) {
        super(driver);
    }
}
