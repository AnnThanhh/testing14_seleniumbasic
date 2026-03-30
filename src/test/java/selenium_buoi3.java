import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class selenium_buoi3 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(20000);
        //findElements -> list<WebElement>
        By byList = By.xpath("//span[text()=\"C18\"]");
        List<WebElement> listC18 = chromeDriver.findElements(byList);
        //nếu k có phân tử nào trên web -> list rỗng
        for ( WebElement element : listC18) {
            System.out.println(element.getText());
        }
//        System.out.println(listC18); // không có xem được nội dung trong list
        System.out.println(listC18.size()); // số lượng phân tử tìm được
        chromeDriver.quit();
    }
}
