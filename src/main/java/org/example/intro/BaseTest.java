package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {

     WebDriver driver;
     BrowserHelper browserHelper;
     AlertHelper alertHelper;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    @AfterClass
    public void close(){
        driver.close();
        driver.quit();
    }
}
