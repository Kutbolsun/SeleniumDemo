package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CssDemo extends BaseTest{

    @Test
    public void cssTest1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        new WebDriverWait(driver,Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-expander-prompt'])[2]"))).click();
//        WebElement seeMore = driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[2]"));
//        seeMore.click();


        List<WebElement> allBrands = driver.findElements(By.xpath("//li[contains(@id,'p_89') and position()<=7]/span/a/div/label/input"));

        for (WebElement e:allBrands){
            System.out.println(e.getText());

            if(e.getText().equals("SAMSUNG")){
                driver.findElement(By.xpath("//*[@id='p_89/SAMSUNG']/span/a/span")).click();
                break;
            }
        }
        Thread.sleep(5000);

    }





}
