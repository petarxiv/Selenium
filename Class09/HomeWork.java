package Class09;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class HomeWork {
    //Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    //click on leave. //click on leave list. // choose from "From calendar"
    // choose from "To calendar" .//click only on cancelled and rejected checkboxes
    // uncheck Pending Approval. //select IT support from DD
    // click search // quit the browser
    public static String url = " http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static <WebELement> void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement leaveListButton = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveListButton.click();
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();
        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select sel = new Select(monthDD);
        sel.selectByVisibleText("Jun");
        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String dateText = fromDate.getText();
            if (dateText.equals("1")) {
                fromDate.click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement calD= driver.findElement(By.id("calToDate"));
        calD.click();
        WebElement mDate= driver.findElement(By.className("ui-datepicker-month"));
        Select select2=new Select(mDate);
        select2.selectByVisibleText("Jul");

        List<WebElement> fromDs=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td"));
        for(WebElement fromD:fromDs){
            String dateText=fromD.getText();
            if (dateText.equals("1")){
                fromD.click();
                break;
            }
        }
        WebElement cancelledButton = driver.findElement(By.id("leaveList_chkSearchFilter_0"));
        cancelledButton.click();
        WebElement rejectedButton=driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
        rejectedButton.click();
        WebElement pendingApproval=driver.findElement(By.xpath("//input[@id=\"leaveList_chkSearchFilter_1\"]"));
        pendingApproval.click();
        WebElement subUnitDD=driver.findElement(By.id("leaveList_cmbSubunit"));
        Select sel2=new Select(subUnitDD);
        sel2.selectByValue("2");
        WebElement searchButton=driver.findElement(By.xpath("//input[@id=\"btnSearch\"]"));
        searchButton.click();
        driver.quit();
    }
}

