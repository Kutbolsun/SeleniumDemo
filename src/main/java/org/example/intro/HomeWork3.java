package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork3 extends BaseTest{
    @Test
    public void testEnterAndPopUp(){
        driver.get("https://www.imoving.com/");
        WebElement houseSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select myHouse = new Select(houseSelectMenu);
        myHouse.selectByVisibleText("My House");
        Helper.pause(1000);
        WebElement dropDownMenuOpen = driver.findElement(By.id("hp-nav-select-house"));
        Select mySize = new Select(dropDownMenuOpen);
        mySize.selectByValue("9509");
        Helper.pause(1000);
        WebElement compareQuotes = driver.findElement(By.xpath(".//button[text()='Compare Quotes']"));
        compareQuotes.click();
        Helper.pause(1000);
        WebElement continueBtn = driver.findElement(By.xpath(".//span[@class='col-sm-9 col-xs-12']"));
        continueBtn.click();
        Helper.pause(1000);
        WebElement gotItBtn = driver.findElement(By.xpath(".//div[@class='modal-buttons']/a"));
        gotItBtn.click();
        Helper.pause(1000);
        WebElement okayBtn = driver.findElement(By.xpath(".//a[@id='closeTutorial']"));
        okayBtn.click();
        Helper.pause(1000);
//        Dresser
        Actions actions = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        actions.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(1000);
//        Bed
        WebElement bedBtn = driver.findElement(By.xpath("//div[@class='13']//figure"));
        actions.moveToElement(bedBtn).perform();
        driver.findElement(By.xpath("//div[@class='13']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
//        TV
        WebElement tvBtn = driver.findElement(By.xpath(".//div[@class='12']//figure"));
        actions.moveToElement(tvBtn).perform();
        driver.findElement(By.xpath("//div[@class='12']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
//        Kitchen
        WebElement kitchenBtn = driver.findElement(By.xpath("//div[@class='11']//figure"));
        actions.moveToElement(kitchenBtn).perform();
        driver.findElement(By.xpath("//div[@class='11']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
//        Sofa
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement sofaBtn = driver.findElement(By.xpath("//div[@class='10']//figure"));
        actions.moveToElement(sofaBtn).perform();
        driver.findElement(By.xpath("//div[@class='10']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
//        Complete Order
        WebElement completeOrderBtn = driver.findElement(By.xpath("//li[@class='box-container'][3]"));
        actions.moveToElement(completeOrderBtn).perform();
        completeOrderBtn.click();
//        Box Calculator
        WebElement smallBox = driver.findElement(By.xpath("(//span[@class='text-center countBlock']//button[@class='quantity-plus'])[1]"));
        smallBox.click();
        WebElement mediumBox = driver.findElement(By.xpath("(//span[@class='text-center countBlock']//button[@class='quantity-plus'])[2]"));
        actions.doubleClick(mediumBox).perform();
        WebElement extraLargeBox = driver.findElement(By.xpath("(//span[@class='text-center countBlock']//button[@class='quantity-plus'])[4]"));
        actions.doubleClick(extraLargeBox).click(extraLargeBox).perform();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)", "");
        WebElement lampBox = driver.findElement(By.xpath("(//span[@class='text-center countBlock']//button[@class='quantity-plus'])[8]"));
        actions.click(lampBox).perform();
        WebElement fileBox = driver.findElement(By.xpath("(//span[@class='text-center countBlock']//button[@class='quantity-plus'])[10]"));
        actions.doubleClick(fileBox).perform();
        Helper.pause(3000);
//        Add and Continue
        WebElement addAndContinue = driver.findElement(By.xpath("//a[contains(text(),'Add and Continue')]"));
        addAndContinue.click();
        Helper.pause(1000);
    }

    @Test
    public void testFinishInventoryList(){
        driver.navigate().to("https://www.imoving.com/full-inventory/#!/moving-details");
        Actions actions = new Actions(driver);
//        Pick Up from
        WebElement pickUpInput = driver.findElement(By.xpath("(//input-auto-complete-address[@name='googleAddress']/span/input)[1]"));
        actions.moveToElement(pickUpInput).perform();
        pickUpInput.sendKeys("123 Melrose Street, Brooklyn, NY, 11206");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        WebElement approveBtn = driver.findElement(By.xpath("(//button[contains(text(),'Approve')])[1]"));
        approveBtn.click();
        Helper.pause(2000);
//        Drop off at
        WebElement dropOffInput = driver.findElement(By.xpath("(//input-auto-complete-address[@name='googleAddress']/span/input)[2]"));
        actions.moveToElement(dropOffInput).perform();
        dropOffInput.sendKeys("123 William Street, New York, NY 10038");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)", "");
        WebElement approveBtn2 = driver.findElement(By.xpath("(//button[contains(text(),'Approve')])[3]"));
        approveBtn2.click();
        Helper.pause(2000);

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,500)", "");

        WebElement chooseMovers = driver.findElement(By.xpath("//button[contains(text(),'Choose Movers')]"));
        chooseMovers.click();
        Helper.pause(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/full-inventory/#!/moving-details");
    }

    @Test
    public void testSelectService(){
        driver.navigate().to("https://www.imoving.com/full-inventory/#!/moving-results");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");



        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Book Now')])[7]"))).click();
//        WebElement allInOneService = driver.findElement(By.xpath("(//button[contains(text(),'Book Now')])[7]"));
//        allInOneService.click();

    }
}
