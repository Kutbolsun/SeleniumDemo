package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsDemo extends BaseTest {

    @Test
    public void testRadioButton(){
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadio = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
        yesRadio.click();

        Assert.assertTrue(yesRadio.isEnabled());
    }

    @Test
    public void testCheckBox(){
        driver.get("https://demoqa.com/checkbox");

        WebElement downButton = driver.findElement(By.xpath("(.//button[@title='Toggle'])[1]"));
        downButton.click();

        WebElement secondDownButton = driver.findElement(By.xpath("(.//button[@title='Toggle'])[2]"));
        secondDownButton.click();

        WebElement commandButton = driver.findElement(By.xpath("(.//span[@class='rct-checkbox'])[4]"));
        commandButton.click();
        Assert.assertTrue(commandButton.isEnabled());

    }
    @Test
    public void testMoveToElementAndSelect(){
        driver.get("https://www.imoving.com/");

        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);

        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
        select.selectByIndex(3);
        Helper.pause(3000);




    }

}
