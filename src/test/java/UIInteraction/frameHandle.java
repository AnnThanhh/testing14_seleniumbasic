package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class frameHandle {
    public static void main(String[] args) {
        //iframe (html5) hoặc frame (html)
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //khởi tạo wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //chuyển đổi frame
        //lưu ý: nếu có nhiều frame lồng nhau thì cần chuyển đổi lần lượt từng cấp độ frame
        driver.switchTo().frame("frame-top"); //chuyển sang frame có name hoặc id là frame-top
        driver.switchTo().frame("frame-middle");

        By byBody = By.tagName("body");
        WebElement txtBody = wait.until(ExpectedConditions.visibilityOfElementLocated(byBody));
        System.out.println("Text in middle frame: " + txtBody.getText());

        driver.quit();
    }
}
