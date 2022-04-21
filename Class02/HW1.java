package Class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

    /*
    HW
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Petar");
        driver.findElement(By.id("customer.lastName")).sendKeys("Ivanov");
        driver.findElement(By.id("customer.address.street")).sendKeys("912 Parker Rd");
        driver.findElement(By.id("customer.address.city")).sendKeys("West Palm Beach");
        driver.findElement(By.id("customer.address.state")).sendKeys("FL");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("33401");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("+7745645643");
        driver.findElement(By.id("customer.ssn")).sendKeys("4456854324");

        driver.findElement(By.id("customer.username")).sendKeys("petarvic");
        driver.findElement(By.id("customer.password")).sendKeys("Petar123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Petar123");
        driver.findElement(By.className("button")).click();
        driver.quit();
    }
}
