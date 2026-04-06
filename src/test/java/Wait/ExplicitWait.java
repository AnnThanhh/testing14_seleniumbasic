package Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {
        //Explicit wait: chờ đợi một điều kiện nào đó xảy ra trước khi thực hiện bước tiếp theo
        //có 2 loại: WebDriverWait và FluentWait

        //khởi tạo webdriver và chrome options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //khai báo 1 webdriver wait với thời gian chờ tối đa là 10s
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // mặc định webdriver wait sẽ tìm kiếm trên web mỗi 0.5s
        // wait.pollingEvery(Duration.ofSeconds(2)); // thay đổi tần suất tìm kiếm element web thành 2s
        // wait.ignoring(Exception.class); // loại bỏ ngoại lệ khi tìm kiếm element web

        //fluent wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // thời gian chờ tối đa
                .pollingEvery(Duration.ofSeconds(3)) // tần suất tìm kiếm element web
                .ignoring(Exception.class); // loại bỏ ngoại lệ khi tìm kiếm element web
        // wait -> fluent wait implement từ wait -> webdriver wait extent từ fluent wait
        By byStartButton = By.xpath("//button[text()=\"Start\"]");
        //cú pháp: wait.until(điều kiện chờ (hàm của ExpectedConditions));
        //điều kiện chờ: element có thể click được (elementToBeClickable)
        WebElement btnStart = wait.until(ExpectedConditions.elementToBeClickable(byStartButton));
        // cảnh báo: không sử dụng implicit wait và explicit wait cùng nhau trong 1 đoạn code
        // vì code sẽ bị chậm và thời gian sẽ bị kéo lên
        btnStart.click();

        //điều kiện kiểm tra 1: kiểm tra kết quả hiển thị
        By byTitle = By.xpath("//h4[text()=\"Hello World!\"]");
        //điều kiện chờ: element hiển thị người dùng có thể thấy được (visibilityOfElementLocated)
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(byTitle));
        boolean isTitleDisplayed = title.isDisplayed();
        System.out.println("isTitleDisplayed: " + isTitleDisplayed);

        //điều kiện kiểm tra 2: kiểm tra loading đã biến mất
        By byLoading = By.id("loading");
        //điều kiện chờ: element biến mất (invisibilityOfElementLocated)
        boolean isDisplay = wait.until(ExpectedConditions.invisibilityOfElementLocated(byLoading));
        System.out.println("isLoadingDisplayed: " + isDisplay);
        driver.quit();
    }
}
