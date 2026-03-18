package tests;

import data.RegisterData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class RegisterTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.pl/index.php");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "registerData", dataProviderClass = RegisterData.class)
    public void testRegister(String email, String firstName, String lastName,
                             String password, String address,
                             String city, String zip, String phone) {

        // ===== Step 1 =====
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        // đợi load (lab thì dùng sleep cho nhanh)
        try { Thread.sleep(3000); } catch (Exception e) {}

        // ===== Step 2 =====
        // Title
        driver.findElement(By.id("id_gender1")).click();

        // First name
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);

        // Last name
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

        // Password
        driver.findElement(By.id("passwd")).sendKeys(password);

        // Date of birth
        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByValue("5");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");

        // Address
        driver.findElement(By.id("address1")).sendKeys(address);

        // City
        driver.findElement(By.id("city")).sendKeys(city);

        // State
        new Select(driver.findElement(By.id("id_state")))
                .selectByVisibleText("New York");

        // Zip
        driver.findElement(By.id("postcode")).sendKeys(zip);

        // Country (default US nên bỏ qua)

        // Phone
        driver.findElement(By.id("phone_mobile")).sendKeys(phone);

        // Scroll xuống
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn = driver.findElement(By.id("submitAccount"));
        js.executeScript("arguments[0].scrollIntoView(true);", btn);

        // Submit
        btn.click();

        // ===== Verify (cơ bản) =====
        try {
            String url = driver.getCurrentUrl();
            if (url.contains("controller=my-account")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}