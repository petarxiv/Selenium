package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo3 {
    public static String url = "http://google.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('http://amazon.com');"); //opens a new tab and navigates to amazon
        //window.open(); -- open a blank tab
        driver.get(url);

        WebElement searchBar=driver.findElement(By.name("q"));
        searchBar.sendKeys("sadasdasdasdasdasdasddff");
    }
}

