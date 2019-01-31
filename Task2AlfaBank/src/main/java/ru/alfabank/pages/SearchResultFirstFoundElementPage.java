package ru.alfabank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultFirstFoundElementPage extends AbstractPage {

    //fixme:Исправить!
    ResultChoiceHeadphonesPage resultChoiceMobilePage = new ResultChoiceHeadphonesPage(driver);

    //Элемент для пункта 13)
    @FindBy(css = "h1.title > a:nth-child(1)")
    private WebElement firstElement;

    public WebElement getFirstElement() {
        return firstElement;
    }

    @Step("13. Найти и проверить, что наименование товара соответствует запомненному значению.")
    public void comparingPageEelements(){
        resultChoiceMobilePage.getFirstFoundElement().getText().equalsIgnoreCase(getFirstElement().getText());
    }

    public SearchResultFirstFoundElementPage(WebDriver driver) {
        super(driver);
    }
}
