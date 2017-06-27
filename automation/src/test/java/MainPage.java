import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tonia on 27.01.2017.
 */
public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "a[href='#sign-up']")
    WebElement registerBtn;

    @FindBy (id = "signUpEmail")
    WebElement enterEmailAddress;

    @FindBy (id = "signUpPassword")
    WebElement enterPassword;

    @FindBy (id = "signUpName")
    WebElement enterName;

    @FindBy (id = "signUpPhone")
    WebElement enterPhone;

    @FindBy (css = "btn btn-default")
    WebElement accountBtn;


    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void swichToRegister() {
        registerBtn.click();
    }

    public void enterEmail(String emailaddress) {
        enterEmailAddress.sendKeys(emailaddress);
    }

    public void enterName (String name) {
        enterName.sendKeys(name);
    }

    public void enterPassword (String password){
        enterPassword.sendKeys(password);
    }

    public void enterPhone (String phone){
        enterPhone.sendKeys(phone);
    }

    public void swichSearchToAccount() {
        accountBtn.click();
    }
}

