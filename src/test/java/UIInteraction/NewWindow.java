package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");

        //khởi tạo wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //trước khi click nút open window
        String mainWindowID = driver.getWindowHandle();
        System.out.println("main window ID: " + mainWindowID);

        By byOpenWindow = By.id("openwindow");
        WebElement btnNewWindow = wait.until(ExpectedConditions.elementToBeClickable(byOpenWindow));
        btnNewWindow.click();

        // kiểm tra các id của các cửa sổ đang mở
        Set<String> listID = driver.getWindowHandles();
        System.out.println("list window ID: " + listID);
        //note về set, HashSet, linkedHashSet, treeSet -> trong 1 collections của java
        // set: không có thứ tự và không có phần tử trùng lặp
        // hashset: không có thứ tự và không có phần tử trùng lặp, sử dụng hash để lưu trữ phần tử
        // linkedHashSet: có thứ tự và không có phần tử trùng lặp, các phần tử được lưu trữ có thứ tự
        // treeSet: có thứ tự và không có phần tử trùng lặp, các phần tử được lưu trữ theo thứ tự tăng dần
        // array, arraylist -> trong 1 collections của java

        //chuyển đổi sang linkedHashSet để có thứ tự
        LinkedHashSet<String> listIDLinkedHashSet = (LinkedHashSet<String>) listID;
        String newWinDowID = listIDLinkedHashSet.getLast();

        driver.switchTo().window(newWinDowID);

        By byHeader = By.xpath("//h1[text()='All Courses']");
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(byHeader));
        System.out.println("All courses is display:  " + header.isDisplayed());

        driver.close(); //đóng cửa sổ hiện tại đang đứng
        //tiếp tục các logic trên cửa sổ chính
        driver.switchTo().window(mainWindowID);

        driver.quit();// đóng toàn bộ cửa sổ trình duyệt đang mở trên driver
    }
}
