package Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

//navigate to http://www.uitestpractice.com/Students/Contact
//        click on the link
//        get text
//        print out in the console

public class HW2 {
    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.linkText("This is a Ajax link"));
        element.click();

        System.out.println(driver.findElement(By.xpath("//div/p")).getText());

    }
}