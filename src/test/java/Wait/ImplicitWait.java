package Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class ImplicitWait {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://demo1.cybersoft.edu.vn/");
//        Thread.sleep(20000);// sẽ luôn chờ 20s
        //áp dụng implicit wait:
        // là 1 cái cấu hình timeout để cài đặt thời gian chờ cho webdriver tìm kiếm element trên web

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //từ động chờ tối đa là 10s để tìm kiếm liên tục (polling DOM) element trên web

        //th1: trong 10s tìm thây element -> trả về element đó
        //th2: trong 10s tìm k thấy element -> trả về lỗi NoSuchElementException

        //áp dụng cho việc tìm kiếm element trên web bằng findElement và findElements sẽ k có kiểm tra điều kiện
        // người dùng có thấy hay k

        //findElements -> list<WebElement>
        By byList = By.xpath("//span[text()=\"C18\"]");
        List<WebElement> listC18 = driver.findElements(byList);
        //nếu k có phân tử nào trên web -> list rỗng
        for ( WebElement element : listC18) {
            System.out.println(element.getText());
        }
//        System.out.println(listC18); // không có xem được nội dung trong list
        System.out.println(listC18.size()); // số lượng phân tử tìm được
        //sleep -> 54 phần tử -> dừng chương trình 10s -> trả về 54 phần tử
        //wait -> 8 phần tử -> tìm liên tục, nếu thay thì trả về ngay, k cần hết 10s
        driver.quit();
    }
}
