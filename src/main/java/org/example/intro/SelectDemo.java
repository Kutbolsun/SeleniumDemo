package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDemo extends BaseTest{

    @Test
    public void testSelectMenu(){
        driver.get("https://demoqa.com/select-menu");

        WebElement selectOption = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        selectOption.sendKeys("Group 1, option 1");
        selectOption.click();

        WebElement selectTitle = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        selectTitle.sendKeys("Mr.");
        selectTitle.click();

        WebElement oldStyle = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyle);
        select.selectByValue("5");

        WebElement multiSelect = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement standardSelect = driver.findElement(By.id("cars"));
        select.selectByValue("audi");
        standardSelect.click();

    }
}
