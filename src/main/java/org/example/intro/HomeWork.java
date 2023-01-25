package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork {

    static WebDriver driver;

    @BeforeTest
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void Testing(){
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String emailAddress = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress  = faker.address().secondaryAddress();


        WebElement fullNameInput = driver.findElement(By.id("userName"));
        WebElement emailAddressInput = driver.findElement(By.id("userEmail"));
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));

        fullNameInput.sendKeys(name);
        emailAddressInput.sendKeys(emailAddress);
        currentAddressInput.sendKeys(currentAddress);
        permanentAddressInput.sendKeys(permanentAddress);

        WebElement summitButton = driver.findElement(By.id("submit"));
        summitButton.click();


        WebElement actualFullName = driver.findElement(By.id("name"));
        WebElement actualEmailAddress = driver.findElement(By.id("email"));
        WebElement actualCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement actualPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));


        String actualFullNameText = actualFullName.getText();
        String actualEmailText = actualEmailAddress.getText();
        String actualCurrentAddressText = actualCurrentAddress.getText();
        String actualPermanentAddressText = actualPermanentAddress.getText();




        Assert.assertEquals(actualFullNameText,"Name:"+name);
        Assert.assertTrue(actualEmailText.contains(emailAddress));
        Assert.assertTrue(actualCurrentAddressText.contains(currentAddress));
        Assert.assertTrue(actualPermanentAddressText.contains(permanentAddress));

    }

    @AfterClass
    public void close(){
        driver.close();
        driver.quit();
    }



}
