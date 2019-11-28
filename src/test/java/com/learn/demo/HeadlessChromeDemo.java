package com.learn.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {

    public static void main(String[] args) throws InterruptedException {
        headlessChrome();
    }
    public static void headlessChrome() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        input.sendKeys("Abcd");
        Thread.sleep(10000);
        driver.findElement(By.name("btnK")).click();
        System.out.println("Search completed");
        driver.close();
        driver.quit();
    }
}
