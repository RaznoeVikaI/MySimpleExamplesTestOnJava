package ru.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectionResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='n-snippet-card2__title']")
    private int countFindNotebooksOnPage;

    public int getCountFindNotebooksOnPage() {
        return countFindNotebooksOnPage;
    }

    /* public void countFindNotebooksOnPaige(){
        WebElement webElement = driver.findElement(By.cssSelector("div[class*='n-snippet-list n-snippet-list_type_vertical b-zone b-spy-init i-bem snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']"));
        String temp = webElement.getAttribute("data-bem");
        int countFindElements = JsonPath.read(temp, "$.b-zone.data.products.count");
        if (countFindElements > 10) {
            System.out.println("Число найденных элементов больше 10.Число найденных элементов: " + countFindElements);
        } else System.out.println(countFindElements);
    }*/

   /* List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
    String tabletName = list.get(0).getText();
        System.out.println(list.size());*/

   public void countFindsNotebooksOnPage(){
       List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
       String tabletName = list.get(0).getText();
       System.out.println(list.size());
   }

    public SelectionResultsPage getResultsPage(){
        return new SelectionResultsPage(driver);
    }

    public SelectionResultsPage(WebDriver driver) {
        super(driver);
    }
}
