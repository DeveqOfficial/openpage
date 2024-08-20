package mx.com.kapitalbank.qa.automation.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource({"classpath:urls.properties",
                 "classpath:xpaths.properties",
                 "classpath:text.properties"})
@ComponentScan({"mx.com.kapitalbank.qa.automation"})
public class ConfigurationSpring {
    private WebDriver driver;
    private WebDriverWait wait;

    @Bean(name = "webdriver")
    public WebDriver driver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @Bean(name = "webdriverwait")
    public WebDriverWait getWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait;
    }
    @Bean(name = "url")
    public ResourceBundleMessageSource getUrl(){
        ResourceBundleMessageSource url = new ResourceBundleMessageSource();
        url.setBasename("urls");
        return url;
    }
    @Bean(name = "xpaths")
    public ResourceBundleMessageSource getXpath(){
        ResourceBundleMessageSource xpath = new ResourceBundleMessageSource();
        xpath.setBasename("xpaths");
        return xpath;
    }
    @Bean(name = "text")
    public ResourceBundleMessageSource getText(){
        ResourceBundleMessageSource text = new ResourceBundleMessageSource();
        text.setBasename("text");
        return text;
    }
}
