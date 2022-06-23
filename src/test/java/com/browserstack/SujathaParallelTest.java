package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SujathaParallelTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
    	  
        // navigate to LandonHomes website
        driver.get("https://www.landonhomes.com");
        
        WebDriverWait wait = new WebDriverWait(driver,55);            
        
        // Check the contact details on Landonhomes page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]")));
        String NewReleaseText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]")).getText();
        Assert.assertEquals(NewReleaseText, "Chat with Landon!  |  469-804-5534");

       
        // Check the search community
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/h1")));
        String CommunityButtonName= driver.findElement(By.xpath("/html/body/div[5]/div/div/h1")).getText();
        Assert.assertEquals(CommunityButtonName, "I’m looking for a...");
        
        // Check the available community link and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[5]/div/div/div/ul/li[1]/a")));
        Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[5]/div/div/div/ul/li[1]/a")).isDisplayed());
       // driver.findElement(By.xpath("//html/body/div[5]/div/div/div/ul/li[1]/a")).click();
        
       // check the result in the new page
        //driver.findElement(By.xpath("//*[@id=\"comm-blocks\"]/li[1]/div/div[2]/div/div/div/div[3]/div/div/div[2]/div[3]/div[2]/a")).isDisplayed();
       
    }
}
