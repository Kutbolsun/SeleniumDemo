package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlovoDemo {
    WebDriver driver;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/kg/en/");
    }

    @Test
    public void xpathTestAgain(){

         new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='onetrust-close-btn-container']/button"))).click();
//        WebElement closeButton = driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']/button"));
//        closeButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='default-wrapper']/div/div/header/div[1]/div[1]/div/div[2]/div[2]"))).click();
//        WebElement getStartedButton = driver.findElement(By.xpath("//*[@id='user-register']/span"));
//        getStartedButton.click();


        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id='signup-name']/div/input"));
        firstNameInput.sendKeys("Hellobek");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id='signup-email']/div/input"));
        emailInput.sendKeys("hello123gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='signup-password']/div/div/input"));
        passwordInput.sendKeys("hello12345");


        Assert.assertEquals(firstNameInput.getAttribute("value"),"Hellobek");
        Assert.assertEquals(emailInput.getAttribute("value"),"hello123gmail.com");
        Assert.assertEquals(passwordInput.getAttribute("value"),"hello12345");

    }

    @AfterClass
    public void close(){
        driver.close();
        driver.quit();
    }
}
