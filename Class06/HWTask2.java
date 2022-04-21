package Class06;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HWTask2 {
    /*
    HW
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly
     */

    public static String url="https://syntaxprojects.com/javascript-alert-box-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement button1=driver.findElement(By.xpath("//button [@class='btn btn-default']"));
        button1.click();
        Alert alert1=driver.switchTo().alert();
        Thread.sleep(2000);
        alert1.accept();

        WebElement button2= driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        button2.click();
        Alert alert2=driver.switchTo().alert();
        Thread.sleep(2000);
        alert2.dismiss();

        WebElement button3=driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        button3.click();
        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("Joey Tang");
        Thread.sleep(2000);
        alert3.accept();

        driver.quit();
    }
}
