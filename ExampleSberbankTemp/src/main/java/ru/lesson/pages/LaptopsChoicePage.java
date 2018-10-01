package ru.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class LaptopsChoicePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='glpricefrom']")
    private WebElement priceFromInput;

    @FindBy(xpath = "//*[@id='glpriceto']")
    private WebElement priceToInput;

    @FindBy()
    private WebElement countElements;

    private Select select;

    public WebElement getCountElements() {
        return countElements;
    }

    public WebElement getPriceFromInput() {
        return priceFromInput;
    }

    public WebElement getPriceToInput() {
        return priceToInput;
    }

    @Step("Проставляем параметры поиска нотубуков")
    public void inputTextIntoInput(String priceFrom, String priceTo){
        getPriceFromInput().clear();
        getPriceFromInput().sendKeys(priceFrom);
        getPriceToInput().clear();
        getPriceToInput().sendKeys(priceTo);
    }

    public Select getSelect(WebElement element){


        select = new Select(element);
        return select;
    }

    public void selectIndex(){
        WebElement temp = driver.findElement(By.cssSelector("body > div.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div.layout__col.i-bem.layout__col_search-results_normal > div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited > div > div.n-pager.i-bem.n-pager_js_inited > span > button"));
        getSelect(temp);
        select.selectByIndex(0);
    }

    public void chouseCountDisplayedNotebooksOnPage(){
        //By.xpath(".//*[@role='listbox']"
        //Кликает по выпадающему списку:"Показать по 12","Показать по 48"
        //WebElement temp = driver.findElement(By.cssSelector("body > div.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div.layout__col.i-bem.layout__col_search-results_normal > div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited > div > div.n-pager.i-bem.n-pager_js_inited > span > button"));
        //temp.click();

     /*   WebElement temp = driver.findElement(By.cssSelector("body > div.main > div:nth-child(6) " +
                "                                                 > div.layout.layout_type_search.i-bem " +
                "                                                 > div.layout__col.i-bem.layout__col_search-results_normal " +
                "                                                 > div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited " +
                "                                                 > div > div.n-pager.i-bem.n-pager_js_inited " +
                "                                                 > span " +
                "                                                 > button"));*/
        //temp.click();


        WebElement buttonTemp = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button"));
        //buttonTemp.click();

        WebElement selectControlTemp = driver.findElement(By.xpath("/html/body/div/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select"));
        WebElement selectOptionTemp = driver.findElement(By.xpath("/html/body/div/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[1]"));
        WebElement selectOptionTemp2 = driver.findElement(By.xpath("/html/body/div/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[2]"));

       //здесь нужен By.xpath
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button")));

        WebElement btb = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", btb);
        btb.click();
        WebElement listTemp = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select"));

        //listTemp.click();
        Select select = new Select(listTemp);
       // select.deselectAll();
       // select.deselectByVisibleText("Показывать по 12");


        WebElement option = driver.findElement(By.xpath(".//option[contains(text(),'Показывать по 12')]"));
        option.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //так вот же
        //wait.until(ExpectedConditions.elementToBeClickable(option));
//        option.click();


        //Ладно хватит, буду сама



//Ладно буду дальеш пробовать не мучайтесб сча еще 5 мин там таймаут больше надо



        //Select listBoxTemp = new Select(driver.findElement(By.xpath(".//*[@role='listbox']")));
        //listBoxTemp.selectByVisibleText("Показывать по 12");



        //WebElement hello1 = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
        //WebElement hello1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[2]")));
        //WebElement hello1 = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[1]"));
        //WebElement hello1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*select__option[@value='12']")));
        //WebElement hello1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[1]")));
        //WebElement option = driver.findElement(By.xpath("//option[@value='12']"));
        // ждем до 10 секунд
        ////WebElement explicitWait = (new WebDriverWait(driver, 10))
        // или пока не появился элемент с id=bar
            ////    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[1]")));
        ////Select selectOption = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select/option[1]")));
        ////selectOption.selectByValue("12");

        //Select select = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/select")));
        //select.deselectAll();
        //select.selectByValue("12");

        //Error!!!
        //Select oSelect = new Select(driver.findElement(By.xpath(".//*[@role='listbox']")));

        //////////explicitScrollIntoView(driver,listBoxTemp,true);

        //Actions action = new Actions(driver);
        //Duration aDuration = Duration.ofSeconds(1);
        //action.moveToElement(selectOptionTemp).pause(aDuration).click(selectControlTemp).build().perform();
        //JavaScriptExecutor jsExec = (JavaScriptExecutor)driver;
        //jsExec.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(selectionSelector)));
        //driver.findElement(By.xpath(selectionSelector)).click();

        //Select select = new Select(listBoxTemp);
        //select.deselectByVisibleText("Показать по 48"); //снимаю выбор элемента по видимому тексту
        //select.deselectAll();

        //List<WebElement> oSize = oSelect.getOptions();
    }

/*    public boolean isElementPresetn(By locator){
        try {
            wait().until((driver) -> driver.findElement(locator));
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public void explicitScrollIntoView(WebDriver webDriver, WebElement elementToScrollIntoView, boolean blockOption) {
        final String scriptStr = "arguments[0].scrollIntoView(" + blockOption + ");";
        ((JavascriptExecutor) webDriver).executeScript(scriptStr, elementToScrollIntoView);

        sleepResponsibly(500);

    }

    public void sleepResponsibly(int timeMillisecond){
        try{
            Thread.sleep(timeMillisecond);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
    }



    @Step("Проверяем результаты отбора")
    public SelectionResultsPage assertResults(){
        return new SelectionResultsPage(driver);
    }

    public LaptopsChoicePage(WebDriver driver) {
        super(driver);
    }
}
