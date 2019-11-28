package com.learn.demo;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumFluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        setWaitSelenium();
    }
    public static void setWaitSelenium() throws InterruptedException {
        //WebDriverManager.firefoxdriver().setup();
        //WebDriver driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        input.sendKeys("Abcd");
        Thread.sleep(10000);
        driver.findElement(By.name("btnK")).click();
        //driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

        // Fluent wait
        // Waiting 30s for an element to be present on the page,
        // for its presence once every 2s
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply(WebDriver driver ) {
                WebElement link = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[10]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
                if(link.isEnabled()){
                    System.out.println("Element found");
                }
                return link;
            }
        });
        //click on the selenium link
        clickseleniumlink.click();

        driver.close();
        driver.quit();
    }
}
