import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_buoi1 {
    public static void main(String[] args) {
        // webdriver là 1 thư viện giúp điều duyệt tự động
        // hỗ trợ 4 trình duyệt: chrome, firefox, edge, safari

        // khởi tạo webdriver
        // cú pháp: WebDriver chromeDriver = new ChromeDriver();
        // WebDriver fireFoxDriver = new FirefoxDriver();
        // WebDriver edgeDriver = new EdgeDriver();
        // WebDriver safariDriver = new SafariDriver();
        try{
            WebDriver chromeDriver = new ChromeDriver();
            //mở full màn hình
            chromeDriver.manage().window().maximize();https://www.google.com/
            // điều hướng đến 1 trang web
            chromeDriver.get("https://www.google.com/");
            Thread.sleep(3000);
            chromeDriver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
