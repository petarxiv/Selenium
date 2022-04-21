package Class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HWTask3 {
    /*  Go to ebay.com
        get all the categories and print them in the console
        select Computers/Tables & Networking
        click on search
        verify the header
     */
    public static String url = "https://www.ebay.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement allCategoriesDD = driver.findElement(By.id("gh-cat"));
        Select select = new Select(allCategoriesDD);

        List<WebElement> allCategories = select.getOptions();
        int size = allCategories.size();
        for (int i = 0; i < size; i++) {
            String allCategoriesText = allCategories.get(i).getText();
            System.out.println(allCategoriesText);
            select.selectByVisibleText("Computers/Tablets & Networking");
        }
        driver.findElement(By.id("gh-btn")).click();
        WebElement header = driver.findElement(By.className("b-pageheader__text"));
        if (header.isDisplayed()) {
            String headerText = header.getText();
            System.out.println(headerText);
            if ("Computers, Tablets & Network Hardware".equals(headerText)) {
                System.out.println("Header Computers, Tablets & Network Hardware is displayed");
            } else {
                System.out.println("Not the correct header");
            }
        } else {
            System.out.println("There is no header");
        }
        driver.quit();
    }
}