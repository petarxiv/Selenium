package Class05;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework01 {
    /*  Facebook dropdown verification
        Open chrome browser
        Go to "https://www.facebook.com"
        click on create new account
     Verify:
        month dd has 12 month options
        day dd has 31 day options
        year dd has 115 year options
        Select your date of birth
     Quit browser

     */
    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewButton = driver.findElement(By.partialLinkText("Create new"));
        createNewButton.click();
        Thread.sleep(2000);

        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthsDD);
        List<WebElement> allMos = selectMonth.getOptions();
        int sizeMos = allMos.size();
        //System.out.println(sizeMos);
        if (sizeMos == 12) {
            System.out.println("Month DD has 12 options");
        } else {
            System.out.println("Month DD doesn't have 12 options. It has " + sizeMos + " options");
        }

        WebElement daysDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(daysDD);
        List<WebElement> allDays = selectDay.getOptions();
        int sizeDays = allDays.size();
        //System.out.println(sizeDays);
        if (sizeDays == 31) {
            System.out.println("Days DD has 31 options");
        } else {
            System.out.println("Days DD doesn't have 31 options. It has " + sizeDays + " options");
        }

        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> allYears = selectYear.getOptions();
        int sizeYears = allYears.size();
        //System.out.println(sizeYears);
        if (sizeYears == 115) {
            System.out.println("Year DD has 115 options");
        } else {
            System.out.println("Year DD doesn't have 115 options. It has " + sizeYears + " options");
        }

        selectMonth.selectByVisibleText("May");
        Thread.sleep(1000);
        selectDay.selectByValue("6");
        Thread.sleep(1000);
        selectYear.selectByValue("1991");
        Thread.sleep(1000);

        driver.quit();
    }
}
