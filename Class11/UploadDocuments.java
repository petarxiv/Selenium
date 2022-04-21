package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDocuments {
    public static String url = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement fileUploadLink=driver.findElement(By.linkText("File Upload"));
        fileUploadLink.click();

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/petarivanov/Desktop/Batch12/Book2.xlsx");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();

    }
}
