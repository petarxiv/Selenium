package Class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarHandling {
    static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList/reset/1";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord=driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement monthDD= driver.findElement(By.className("ui-datepicker-month"));
        Select sel=new Select(monthDD);
        sel.selectByVisibleText("Jul");
        List<WebElement> fromDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calender']/tbody/tr/td"));
        for(WebElement fromDate:fromDates){
            String dateText=fromDate.getText();
            if (dateText.equals("4")){
                fromDate.click();
                break;
            }
        }
WebElement doneButton=driver.findElement(By.className("doneButton"));
        doneButton.click();


    }
}