package mx.com.kapitalbank.qa.automation.page;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;
import mx.com.kapitalbank.qa.automation.configuration.ConfigurationSpring;
import mx.com.kapitalbank.qa.automation.dto.readproperties.ReadProperties;
import mx.com.kapitalbank.qa.automation.dto.screenshot.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;

import java.io.IOException;

@CucumberContextConfiguration
@ContextConfiguration(classes = ConfigurationSpring.class)
public class OpenPage {
    @Autowired
    @Qualifier("webdriver")
    private WebDriver driver;
    @Autowired
    private ReadProperties read;
    @Autowired
    private WebDriverWait wait;
    @Autowired
    private TakeScreenshot screenshot;
    private WebElement element;
    public static String testCase;


    @Dado("que soy un usuario certificado capitalbank con un {string}")
    public void given(String testCase) throws InterruptedException, IOException {
        this.testCase = testCase;
        driver.get(read.url("EndPoint"));
        driver.manage().window().maximize();
        screenshot.takeScreenshot("00home");
        String title = driver.getTitle();
        Assert.assertEquals(title, read.text("Assert01"));
        Thread.sleep(500);
    }

    @Cuando("ingreso con el usuario {string} y contraseña {string}")
    public void when(String user, String pass) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(read.xpath("user")))).sendKeys(user);
        screenshot.takeScreenshot("01user");
        wait.until(ExpectedConditions.elementToBeClickable(By.id(read.xpath("pass")))).sendKeys(pass);
        screenshot.takeScreenshot("02pass");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(read.xpath("login")))).click();
        screenshot.takeScreenshot("03submit");
        element = driver.findElement(By.xpath(read.xpath("usrvalidorinvalid")));
    }

    @Entonces("valido que el logueo fue exitoso")
    public void then() throws NullPointerException, IOException {
        if (element.getText().equals(read.text("Assert04"))) {
            System.out.println(read.text("Assert02"));
            screenshot.takeScreenshot("04Success");
        } else {
            System.out.println(read.text("Assert03"));
            screenshot.takeScreenshot("04wrong");
        }
    }
}