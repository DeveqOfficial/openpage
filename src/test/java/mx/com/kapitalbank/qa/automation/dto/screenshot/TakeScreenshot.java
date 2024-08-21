package mx.com.kapitalbank.qa.automation.dto.screenshot;

import mx.com.kapitalbank.qa.automation.steps.unitary.OpenPageSteps;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Service
public class TakeScreenshot {
    @Autowired
    @Qualifier("webdriver")
    private WebDriver driver;

    public void takeScreenshot(String nameSS) throws IOException {
        Screenshot screenshot = new AShot().takeScreenshot(driver);;
        ImageIO.write(screenshot.getImage(), "jpg", new File(String.format("images/screenshots/%s_image_%s.jpg", OpenPageSteps.testCase,nameSS)));
    }
}
