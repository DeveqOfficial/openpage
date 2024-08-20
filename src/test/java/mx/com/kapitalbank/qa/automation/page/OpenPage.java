package mx.com.kapitalbank.qa.automation.page;

import io.cucumber.java.bs.A;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import mx.com.kapitalbank.qa.automation.configuration.ConfigurationSpring;
import mx.com.kapitalbank.qa.automation.dto.readproperties.ReadProperties;
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

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Slf4j
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
    private WebElement element;


    @Dado("que soy un usuario certificado capitalbank")
    public void given() throws InterruptedException {
        driver.get(read.url("EndPoint"));
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals(title, read.text("Assert01"));
        Thread.sleep(500);
    }

    @Cuando("ingreso con el usuario {string} y contraseña {string}")
    public void when(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(read.xpath("user")))).sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(read.xpath("pass")))).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(read.xpath("login")))).click();
        element = driver.findElement(By.xpath(read.xpath("success")));
    }

    @Entonces("valido que el logueo fue exitoso")
    public void then() throws NullPointerException {
        if (element.getText().equals(read.text("Assert04"))) {
            System.out.println(read.text("Assert02"));
        }
    }
}