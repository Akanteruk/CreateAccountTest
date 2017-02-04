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

    @FindBy(css = "a[href='#register']")
    WebElement registerBtn;

    @FindBy (id = "firstname")
    WebElement enterFirstname;

    @FindBy (id = "lastname")
    WebElement enterLastname;

    @FindBy (id = "registerEmail")
    WebElement enterregisterEmail;

    @FindBy (id = "pwd1")
    WebElement enterpwd1;

    @FindBy (id = "phone")
    WebElement enterphone;

    @FindBy (id = "coupone_code")
    WebElement entercouponecode;

    @FindBy (id = "register-account-submit")
    WebElement accountBtn;


    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void swichToRegister() {
        registerBtn.click();
    }

    public void enterFn(String firstname) {
        enterFirstname.sendKeys(firstname);
    }

    public void enterLn (String lastname) {
        enterLastname.sendKeys(lastname);
    }

    public void enterRegEmail (String registerEmail){
        enterregisterEmail.sendKeys(registerEmail);
    }

    public void enterPwd1 (String pwd1){
        enterpwd1.sendKeys(pwd1);
    }

    public void enterPhone (String phone){
        enterphone.sendKeys(phone);
    }

    public void enterCouponeCode (String coupone_code){
        entercouponecode.sendKeys(coupone_code);
    }

    public void swichSearchToAccount() {
        accountBtn.click();
    }
}

