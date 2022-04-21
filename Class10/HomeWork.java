package Class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    /*
    HW
Go to aa.com/homePage.do
select depart date
select return date
select destination
click on search
quit the browser
     */
    public static String url = " http://aa.com/homePage.do";

    public static <WebELement> void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//-------------------------
        WebElement departureDate = driver.findElement(By.className("ui-datepicker-trigger"));
        departureDate.click();
        WebElement dMonth = driver.findElement(By.className("ui-datepicker-month"));
        String dMonthText = dMonth.getText();

        while (!dMonthText.equals("November")) {
            WebElement nextBttn = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextBttn.click();
            dMonth = driver.findElement(By.className("ui-datepicker-month"));
            dMonthText = dMonth.getText();

        }
        List<WebElement> departDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement dDate : departDates) {
            if (dDate.getText().equals("12")) {
                dDate.click();
                break;
            }
        }

        //-------------------
        WebElement returnCal = driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[4]/div[2]/div/button"));
        returnCal.click();
        WebElement returnMonth = driver.findElement(By.className("ui-datepicker-month"));
        String returnMoText = returnMonth.getText();


        while (!returnMoText.equals("February")) {
            WebElement nextBttn = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextBttn.click();
            returnMonth = driver.findElement(By.className("ui-datepicker-month"));
            returnMoText = returnMonth.getText();

        }
        List<WebElement> returnDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement returnDate : returnDates) {
            if (returnDate.getText().equals("13")) {
                returnDate.click();
                break;
            }
        }

        WebElement destination = driver.findElement(By.name("destinationAirport"));
        destination.click();
        destination.sendKeys("MIA");

        WebElement searchBttn = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchBttn.click();
        driver.quit();

    }
}