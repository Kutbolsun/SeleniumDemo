package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImovingHomeWork extends BaseTest{


    @Test
    public void testEnter(){
        driver.get("https://www.imoving.com/");

        WebElement houseSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select myHouse = new Select(houseSelectMenu);
        myHouse.selectByVisibleText("My House");
        Helper.pause(3000);

        WebElement dropDownMenuOpen = driver.findElement(By.id("hp-nav-select-house"));
        Select mySize = new Select(dropDownMenuOpen);
        mySize.selectByValue("9509");
        Helper.pause(3000);


        WebElement compareQuotes = driver.findElement(By.xpath(".//button[text()='Compare Quotes']"));
        compareQuotes.click();
        Helper.pause(2000);


    }

    @Test
    public void testSettingWebSite() {
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement continueBtn = driver.findElement(By.xpath(".//span[@class='col-sm-9 col-xs-12']"));
        continueBtn.click();
        Helper.pause(3000);
        WebElement gotItBtn = driver.findElement(By.xpath(".//div[@class='modal-buttons']/a"));
        gotItBtn.click();
        Helper.pause(3000);
        WebElement okayBtn = driver.findElement(By.xpath(".//a[@id='closeTutorial']"));
        okayBtn.click();
        Helper.pause(3000);

//      Dresser
        Actions actions = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        actions.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);

        WebElement plusDresserBtn = driver.findElement(By.xpath("(//span[@class='quantityCounterBlock']//button[@class='quantity-plus'])[1]"));
        actions.doubleClick(plusDresserBtn).perform();
        Helper.pause(3000);

//        Bed
        WebElement bedBtn = driver.findElement(By.xpath("//div[@class='13']//figure"));
        actions.moveToElement(bedBtn).perform();
        driver.findElement(By.xpath("//div[@class='13']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);

        WebElement plusBedBtn = driver.findElement(By.xpath("(//span[@class='quantityCounterBlock']//button[@class='quantity-plus'])[2]"));
        actions.doubleClick(plusBedBtn).perform();
        Helper.pause(1000);

//        TV
        WebElement tvBtn = driver.findElement(By.xpath(".//div[@class='12']//figure"));
        actions.moveToElement(tvBtn).perform();
        driver.findElement(By.xpath("//div[@class='12']//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);

        WebElement plusTvBtn = driver.findElement(By.xpath("(//span[@class='quantityCounterBlock']//button[@class='quantity-plus'])[3]"));
        actions.doubleClick(plusTvBtn).perform();
        Helper.pause(1000);

        WebElement arrowRightBtn = driver.findElement(By.xpath(".//div[@class='rightPanelContainer']/div[1]"));
        arrowRightBtn.click();
        Helper.pause(1000);

        WebElement plusBtn = driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[1]"));
        plusBtn.click();
        Helper.pause(3000);

        WebElement expectedItems = driver.findElement(By.xpath("(//span[@class='room-counter'])[1]"));
        Assert.assertEquals(expectedItems.getText(),"9 items");




    }
}
