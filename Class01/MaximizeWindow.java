package Class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize(); //I will be using this one to make the window bigger
        //driver.manage().window().fullscreen(); //makes it full screen
    }
}
