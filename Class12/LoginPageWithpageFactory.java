package Class12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageWithpageFactory {
    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(xpath = "//input[@id= 'txtPassword']")
    public WebElement password;

    @FindBy(css ="input#btnLogin")
    public WebElement loginButton;
}
