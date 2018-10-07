package ru.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerTechnikPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-reactid='16']")
    private WebElement laptopsLink;

    public WebElement getLaptopsLink() {
        return laptopsLink;
    }

    @Step("Переходим на страницу Ноутбуки")
    public LaptopsChoicePage submitLaptopsLink(){
        getLaptopsLink().click();
        return new LaptopsChoicePage(driver);
    }


    public ComputerTechnikPage(WebDriver driver) {
        super(driver);
    }
}
