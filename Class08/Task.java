package Class08;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//go to https://the-internet.herokuapp.com/dynamic_controls
//click on checkbox and click on remove
//verify the text
//click on enable verify the textbox is enabled
//enter text and click disable
//verify the textbox is disabled
public class Task {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        WebElement checkBox= driver.findElement(By.xpath("//button[contains(text(),\"Remove\")]"));
        checkBox.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement message= driver.findElement(By.id("message"));
        System.out.println(message.getText());


        WebElement removeB= driver.findElement(By.xpath("//button[@type='button']"));
        removeB.click();
        WebElement addMessage= driver.findElement(By.id("message"));
        System.out.println(addMessage.getText());

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement enableB= driver.findElement(By.xpath("//button[text()=\"Enable\"]"));
        enableB.click();
        WebElement enableMessage= driver.findElement(By.id("message"));
        System.out.println(enableMessage.getText());

        WebElement disableB= driver.findElement(By.xpath("//button[text()=\"Disable\"]"));
        disableB.click();
        WebElement disableMessage= driver.findElement(By.id("message"));
        System.out.println(disableMessage.getText());


    }
}