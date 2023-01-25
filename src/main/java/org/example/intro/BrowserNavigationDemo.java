package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationDemo extends BaseTest {

    @Test
    public void test1(){
        driver.navigate().to("https://www.imoving.com/");

        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);
        WebElement dropDownMenuOpen = driver.findElement(By.id("hp-nav-select-house"));
        Select mySize = new Select(dropDownMenuOpen);
        mySize.selectByValue("9509");
        Helper.pause(3000);
        WebElement compareQuotes = driver.findElement(By.xpath(".//button[text()='Compare Quotes']"));
        compareQuotes.click();
        Helper.pause(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/full-inventory/#!/");
        driver.navigate().back();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/");
        driver.navigate().refresh();
        Helper.pause(3000);
        driver.navigate().forward();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/full-inventory/#!/");
    }
}
