import lib.ExcelDataConfig;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

/**
 * Created by Tonia on 31.01.2017.
 */
public class AccountTest {
    MainPage mainPage;
    WebDriver webDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

    @org.testng.annotations.Test (dataProvider = "accountInvalidData")
    public void accountInvalidData(String emailaddress, String name,
                                   String password, String phone) throws InterruptedException
    {
        mainPage = new MainPage(webDriver);
        webDriver.get("https://app.cms2cms.com/auth");

        System.out.println("Step 1: Switch to Create Account");
        mainPage.swichToRegister();

        System.out.println("Step 2: Enter EmailAddress");
        mainPage.enterEmail(emailaddress);

        System.out.println("Step 3: Enter Password");
        mainPage.enterPassword(password);

        System.out.println("Step 4: Enter FullName");
        mainPage.enterName(name);

        System.out.println("Step 5: Enter Phone");
        mainPage.enterPhone(phone);

        System.out.println("Step 6: Switch button Sign up");
        mainPage.swichSearchToAccount();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-center green-text")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://app.cms2cms.com/auth#sign-in"));
        System.out.println("Account is not created");
    }

    @org.testng.annotations.Test (dataProvider = "accountValidData")
    public void accountValidData(String emailaddress, String name,
                              String password, String phone) throws InterruptedException
    {

        mainPage = new MainPage(webDriver);
        webDriver.get("http://app.yaware.com/");

        System.out.println("Step 1: Switch to Create Account");
        mainPage.swichToRegister();

        System.out.println("Step 2: Enter EmailAddress");
        mainPage.enterEmail(emailaddress);

        System.out.println("Step 3: Enter Password");
        mainPage.enterPassword(password);

        System.out.println("Step 4: Enter FullName");
        mainPage.enterName(name);

        System.out.println("Step 5: Enter Phone");
        mainPage.enterPhone(phone);

        System.out.println("Step 6: Switch button Sign up");
        mainPage.swichSearchToAccount();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("green-text text-center")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://app.cms2cms.com/dashboard"));
        System.out.println("Account is created");
    }

    @After
    public void cleanUP ()
    {
        webDriver.quit();
    }

    @DataProvider(name = "accountInvalidData")
    public Object[][] passInvalidData()
    {
        return getData("AccountInvalidData");
    }

    @DataProvider(name = "accountValidData")
    public Object[][] passValidData()
    {
        return getData("AccountValidData");
    }

    private Object[][] getData(String sheetName)
    {
        ExcelDataConfig config = new ExcelDataConfig("..\\ExcelData\\TestData.xls");
        int rows = config.getRowCount(sheetName);
        Object[][] data = new Object[rows][4];
        for(int i=0; i < rows; i++)
        {
            data[i][0] = config.getData(sheetName, i,0);
            data[i][1] = config.getData(sheetName, i,1);
            data[i][2] = config.getData(sheetName, i,2);
            data[i][3] = config.getData(sheetName, i,3);
        }
        return data;
    }
}
