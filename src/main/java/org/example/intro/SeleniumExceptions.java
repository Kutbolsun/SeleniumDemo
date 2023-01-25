package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void noSuchElementExceptionTest(){
//        NOSuchElementException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");
    }

    @Test
    public void noSuchWindowExceptionTest(){
//        NoSuchWindowException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("4");

    }

    @Test
    public void noSuchFrameExceptionTest(){
//        NoSuchFrameException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertExceptionTest(){
//        NoAlertPresentException
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();

    }

    @Test
    public void InvalidSelectorExceptionTest(){
//        InvalidSelectorException
        browserHelper.openURL("https://demoqa.com/text-box");
        SessionId s =((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID id: " + s );
//        driver.findElement(By.xpath("//button[@type='button'][100]"));
    }

    @Test
    public void noSuchSessionExceptionTest(){
//        NoSuchSessionException
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceExceptionTest(){
//        StaleElementReferenceException
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
            }
        }
    }

    @Test
    public void timeOutExceptionTest(){
//        TimeOutException
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }

    @Test
    public void test123(){
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).click();
    }

    @Test
    public void elementNotInteractableExceptionTest(){
//        ElementNotInteractable
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas");

    }

    @Test
    public void elementClickInterceptedExceptionTest(){
//        ElementClickInterceptedException
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).click();

    }


    @Test
    public void notFoundExceptionTest(){
        browserHelper.openURL("https://demoqa.com/upload-download");
        driver.findElement(By.xpath("//svg[@stroke ='currentColor']")).click();
    }
    @Test
    public void noSuchAttributeElementTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        WebElement element = driver.findElement(By.id("userName"));
        String name = element.getAttribute("Hello");
        element.getAttribute(name);
    }



}
