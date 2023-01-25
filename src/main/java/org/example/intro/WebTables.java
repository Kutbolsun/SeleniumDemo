package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends BaseTest{

    @Test
    public void testPage(){
        Faker faker = new Faker();

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String age = String.valueOf( faker.number().numberBetween(18,80));
        String salary = String.valueOf(faker.number().numberBetween(0,100000));
        String department = faker.company().profession();

        driver.get("https://demoqa.com/webtables");
        WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
        addBtn.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(name);
        WebElement secondName = driver.findElement(By.id("lastName"));
        secondName.sendKeys(lastName);
        WebElement emailAddress = driver.findElement(By.id("userEmail"));
        emailAddress.sendKeys(email);
        WebElement ageInput = driver.findElement(By.id("age"));
        ageInput.sendKeys(age);
        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys(salary);
        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.sendKeys(department);
        Helper.pause(3000);
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Helper.pause(3000);

        List<WebElement> dataList = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        for (WebElement element:dataList){
            System.out.println(element.getText());

        }





    }
}
