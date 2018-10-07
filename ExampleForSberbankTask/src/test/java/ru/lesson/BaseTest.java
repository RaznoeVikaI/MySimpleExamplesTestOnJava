package ru.lesson;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import ru.lesson.utills.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");
    @Before
    public void tearUp(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT),TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
        driver.get("https://yandex.ru");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}