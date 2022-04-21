package Class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTask {

    /**
     *  navigate http://syntaxprojects.com/dynamic-elements-loading.php
     *  click on start button
     *  get the text
     *  print out in console
     */
    public static String url = "http://syntaxprojects.com/dynamic-elements-loading.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement startButton =driver.findElement(By.cssSelector("button#startButton"));
        startButton.click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Syntax')]")));
        WebElement welcome=driver.findElement(By.xpath("//h4[contains(text(),'Syntax')]"));
        System.out.println(welcome.getText());



    }
}
