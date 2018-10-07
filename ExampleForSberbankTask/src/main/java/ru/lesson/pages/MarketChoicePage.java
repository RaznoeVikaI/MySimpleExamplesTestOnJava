package ru.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketChoicePage extends AbstractPage {

    @FindBy(xpath = "//*[@data-department='Компьютеры']")
    private WebElement computersLink;

    public WebElement getComputersLink() {
        return computersLink;
    }

    @Step("Переходим на страницу Компьютеры")
    public ComputerTechnikPage submitComputersLink(){
        getComputersLink().click();
        return new ComputerTechnikPage(driver);
    }

    public MarketChoicePage(WebDriver driver) {
        super(driver);
    }
}