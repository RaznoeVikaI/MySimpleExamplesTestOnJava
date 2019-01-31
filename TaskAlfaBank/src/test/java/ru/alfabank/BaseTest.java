package ru.alfabank;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.alfabank.utills.PropertyReader;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class BaseTest
{

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");


    @Step("1) Открыть браузер и развернуть на весь экран. 2) Зайти на yandex.ru.")
    @Before
    public void tearUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
        driver.get("https://yandex.ru");
    }

    /*    @After
    public void tearDown(){
        driver.quit();
    }*/
}
