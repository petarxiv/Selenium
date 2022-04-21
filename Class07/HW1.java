package Class07;

//Go to https://demoqa.com/browser-windows
//        click on New Tab and print the text from new tab in the console
//        click on New Window and print the text from new window in the console
//        click on New Window Message and print the text from new window in the console
//        Verify (compare) the titles for each page
//        Print out the title of the all pages

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPageHandle = driver.getWindowHandle();

        driver.findElement(By.cssSelector("button#tabButton")).click();
        driver.findElement(By.cssSelector("button#windowButton")).click();
        driver.findElement(By.cssSelector("button#messageWindowButton")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String handle = it.next();
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);
                System.out.println("Body Text: " + driver.findElement(By.cssSelector("body")).getText());
            }
            if (!driver.getTitle().isEmpty()) {
                System.out.println("Title: " + driver.getTitle());
            } else {
                System.out.println("Title: EMPTY");
            }
        }

        driver.quit();
    }
}