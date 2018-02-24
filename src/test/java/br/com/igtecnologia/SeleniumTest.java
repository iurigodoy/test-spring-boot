package br.com.igtecnologia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
    	
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com.br");

        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Caelum");
        query.submit();
        
        driver.close();

    }
}
