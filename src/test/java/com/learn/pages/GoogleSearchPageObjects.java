package com.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

    WebDriver driver = null;

    public GoogleSearchPageObjects(WebDriver driver){
        this.driver = driver;
    }

    By textbx_search = By.name("q");
    By button_search = By.name("btnK");

    public void setTextInSearchBox(String text){
        driver.findElement(textbx_search).sendKeys(text);
    }
    public void clickSearchButton(){
        driver.findElement(button_search).sendKeys(Keys.RETURN);
    }
}
