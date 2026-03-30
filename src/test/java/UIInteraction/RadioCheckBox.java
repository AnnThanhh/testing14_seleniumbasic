package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioCheckBox {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");
        Thread.sleep(3000);
//
//        //click BMW
//        By byRadioBMW = By.id("bmwradio");
//        WebElement radioBMW = driver.findElement(byRadioBMW);
//        radioBMW.click();
//
//        //click Benz
//        By byRadioBenz = By.id("benzradio");
//        WebElement radioBenz = driver.findElement(byRadioBenz);
//        radioBenz.click();
            String dynamicLocator = "//input[@id=\"%s\"]";
            handleRadio(driver, dynamicLocator, "bmwradio");
        driver.quit();
    }

    public static void handleRadio(WebDriver driver, String dynamicLocator, String value){
        // ví dụ: //input[@id="bmwradio"]
        //dynamic string "%s" -> dynamic xpath -> //input[@id="%s"] (dynamicLocator)
        // input[@id="%s" and @value="%s"]
        // string.format(locator, value, value2)
        // thay thế tương ứng %s trong dynamicLocator bằng value
        //value = "bmwradio" -> locatorValue = //input[@id="bmwradio"]
        //string.format: thay thế %s trong dynamicLocator bằng value
        String locatorValue = String.format(dynamicLocator, value);//input[@id="bmwradio"]
        By byRadio = By.xpath(locatorValue);
        WebElement radio = driver.findElement(byRadio);
        radio.click();
    }
}
