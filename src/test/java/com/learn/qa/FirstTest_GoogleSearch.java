package com.learn.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        googleSearch();
    }

    public static void googleSearch() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        input.sendKeys("Selenium qa");
        //driver.findElement(By.name("btnK")).click();
        // Below will press enter key (Return is enter)
        Thread.sleep(5000);
         driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

        driver.close();
        driver.quit();
    }

}
