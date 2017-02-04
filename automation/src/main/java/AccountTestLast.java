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
public class AccountTestLast {
    MainPage mainPage;
    WebDriver webDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

    @org.testng.annotations.Test (dataProvider = "accountInvalidData")
    public void accountInvalidData(String firstname, String lastname, String registerEmail,
                                   String pwd1, String phone) throws InterruptedException
    {
        mainPage = new MainPage(webDriver);
        webDriver.get("http://app.yaware.com/");

        System.out.println("Step 1: Switch to Create Account");
        mainPage.swichToRegister();

        System.out.println("Step 2: Enter FirstName");
        mainPage.enterFn(firstname);

        System.out.println("Step 3: Enter LastName");
        mainPage.enterLn(lastname);

        System.out.println("Step 4: Enter Email");
        mainPage.enterRegEmail(registerEmail);

        System.out.println("Step 5: Enter Password");
        mainPage.enterPwd1(pwd1);

        System.out.println("Step 6: Enter Phone");
        mainPage.enterPhone(phone);

        System.out.println("Step 7: Switch button Create");
        mainPage.swichSearchToAccount();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("panel-heading")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("http://app.yaware.com/#register"));
        System.out.println("Account is not created");
    }

    @org.testng.annotations.Test (dataProvider = "accountValidData")
    public void accountValidData(String firstname, String lastname, String registerEmail,
                              String pwd1, String phone) throws InterruptedException
    {

        mainPage = new MainPage(webDriver);
        webDriver.get("http://app.yaware.com/");

        System.out.println("Step 1: Switch to Create Account");
        mainPage.swichToRegister();

        System.out.println("Step 2: Enter FirstName");
        mainPage.enterFn(firstname);

        System.out.println("Step 3: Enter LastName");
        mainPage.enterLn(lastname);

        System.out.println("Step 4: Enter Email");
        mainPage.enterRegEmail(registerEmail);

        System.out.println("Step 5: Enter Password");
        mainPage.enterPwd1(pwd1);

        System.out.println("Step 6: Enter Phone");
        mainPage.enterPhone(phone);

        System.out.println("Step 7: Switch button Create");
        mainPage.swichSearchToAccount();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("panel-heading")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("http://app.yaware.com/welcome"));
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
        Object[][] data = new Object[rows][5];
        for(int i=0; i < rows; i++)
        {
            data[i][0] = config.getData(sheetName, i,0);
            data[i][1] = config.getData(sheetName, i,1);
            data[i][2] = config.getData(sheetName, i,2);
            data[i][3] = config.getData(sheetName, i,3);
            data[i][4] = config.getData(sheetName, i,4);
        }
        return data;
    }
}
