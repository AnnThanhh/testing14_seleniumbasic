package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkbox {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);

        // 2 trường hợp
        //1: checkbox chưa được chọn -> click vào để chọn
        By byCheckBox1 = By.xpath("(//input[@type=\"checkbox\"])[1]");
        handleCheckbox(chromeDriver, byCheckBox1, true);
        //2: checkbox đã được chọn -> click vào để bỏ chọn
        By byCheckBox2 = By.xpath("(//input[@type=\"checkbox\"])[2]");
        handleCheckbox(chromeDriver, byCheckBox2, false);
        Thread.sleep(3000);
        chromeDriver.quit();
    }

    /**
     * @param driver: driver đang sử dụng
     * @param byCheckbox: vị trí của checkbox trên web
     * @param status: trạng thái mong muốn của checkbox (true: chọn, false: bỏ chọn)
     */
    //hàm xử lý checkbox
    public static void handleCheckbox(WebDriver driver, By byCheckbox, Boolean status ){

        WebElement checkbox = driver.findElement(byCheckbox);
        Boolean isSelected = checkbox.isSelected(); // kiểm tra trạng thái của checkbox
        if(status != isSelected){
            checkbox.click();
        }
    }
}
