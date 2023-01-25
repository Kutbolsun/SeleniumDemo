package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameDemo extends BaseTest{

    @Test
    public void testFrame(){
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(2);
        WebElement text = driver.findElement(By.id("sampleHeading"));
        System.out.println(text.getText());

//        back to parent HTML
        driver.switchTo().defaultContent();

        driver.switchTo().frame(3);
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        System.err.println(text2.getText());

        driver.switchTo().defaultContent();

        WebElement frameText = driver.findElement(By.xpath("//div[contains(text(),'Frames')]"));
        System.out.println(frameText.getText());




    }
}
