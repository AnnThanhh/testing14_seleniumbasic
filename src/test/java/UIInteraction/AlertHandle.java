package UIInteraction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandle {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //khởi tạo wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By btnAlert = By.xpath("//button[text()='Click for JS Alert']");
        By btnConfirm = By.xpath("//button[text()='Click for JS Confirm']");
        By btnPrompt = By.xpath("//button[text()='Click for JS Prompt']");

        WebElement btnJS = wait.until(ExpectedConditions.elementToBeClickable(btnAlert));
        btnJS.click();
        //chuyển sang alert
        Alert jsAlert = driver.switchTo().alert();
        System.out.println("Alert text: " + jsAlert.getText());
//        thread.sleep(2000);
        jsAlert.accept(); // nhấn nút OK trên alert

        WebElement btnJSConfirm = wait.until(ExpectedConditions.elementToBeClickable(btnConfirm));
        btnJSConfirm.click();
        Alert jsConfirm = driver.switchTo().alert();
        System.out.println("Confirm text: " + jsConfirm.getText());
        jsConfirm.dismiss(); // nhấn nút Cancel trên alert
        //jsConfirm.accept(); // nhấn nút OK trên alert

        WebElement btnJSPrompt = wait.until(ExpectedConditions.elementToBeClickable(btnPrompt));
        btnJSPrompt.click();
        Alert jsPrompt = driver.switchTo().alert();
        System.out.println("Prompt text: " + jsPrompt.getText());
        jsPrompt.sendKeys("Selenium Alert"); // nhập text vào prompt
        jsPrompt.accept(); // nhấn nút OK trên alert

        driver.quit();
    }
}
