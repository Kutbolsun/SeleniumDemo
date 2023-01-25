package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    private Alert alert ;

    public void acceptAlert(){
       alert = driver.switchTo().alert();
       alert.accept();
    }

    public void dismissAlert(){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendKeys(String text){
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

}
