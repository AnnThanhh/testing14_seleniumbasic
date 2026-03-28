import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium_buoi1 {
    public static void main(String[] args) throws InterruptedException {
        // webdriver là 1 thư viện giúp điều duyệt tự động
        // hỗ trợ 4 trình duyệt: chrome, firefox, edge, safari

        // khởi tạo webdriver
        // cú pháp: WebDriver chromeDriver = new ChromeDriver();
        // WebDriver fireFoxDriver = new FirefoxDriver();
        // WebDriver edgeDriver = new EdgeDriver();
        // WebDriver safariDriver = new SafariDriver();

        //vô hiệu hóa việc nhận diện trình duyệt đang được điều khiển bởi Selenium
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        //mở full màn hình
        chromeDriver.manage().window().maximize();https://www.google.com/
        // điều hướng đến 1 trang web
        chromeDriver.get("https://www.google.com/");
        Thread.sleep(3000);
        chromeDriver.quit();



    }
}
