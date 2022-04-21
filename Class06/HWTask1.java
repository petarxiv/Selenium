package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {
    /*
    Task
Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
verify enroll today button is enabled
     */
    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        Thread.sleep(500);

        //header
        WebElement header= driver.findElement(By.linkText("AUTOMATION TESTING PLATFORM BY SYNTAX"));
        if (header.isDisplayed()){
            System.out.println("Header is verified");
        }else{
            System.out.println("Header is not verified");
        }
        //switch frame
        driver.switchTo().frame("FrameTwo");
        WebElement frame2= driver.findElement(By.linkText("Enroll today"));

        if (frame2.isEnabled()){
            System.out.println("Enroll button is enabled");
        }else{
            System.out.println("Enroll button is not enabled");
        }
        driver.quit();
    }
}


