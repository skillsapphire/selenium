package com.learn.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        setWaitSelenium();
    }
    public static void setWaitSelenium(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        input.sendKeys("Selenium qa");
        //Implicit wait, use it for a whole session
        // default polling of implicit time 250ms
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Explicit wait , use it for any element that takes longer
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        driver.findElement(By.name("btnK")).click();
        //input = driver.findElement(By.xpath("//input[@name=\"qii\"]"));
        driver.close();
        driver.quit();
    }
}
