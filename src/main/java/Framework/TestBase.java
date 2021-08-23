package Framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class TestBase extends DriverManager{

    private static WebDriver driver;

    public static WebDriver getDriver(){
        driver = getDriver(TypeDriver.CHROME);
        return driver;
    }

    @BeforeAll
    public static void setUp(){
        getDriver().get("http://automationpractice.com/index.php");
    }

    @AfterAll
    public static void tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        quitDriver();
    }
}
