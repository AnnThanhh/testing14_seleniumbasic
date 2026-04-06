package demo_script_buoi2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class script_buoi2 {
    public static void main(String[] args) throws InterruptedException {
        //b1: khởi tao webdriver và chrome option
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        //b2: di toi trang web https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        //b3: tìm kiếm tới vị trí ô input username
        By byInputUsername = By.name("username");
        WebElement inputUsername =chromeDriver.findElement(byInputUsername);
        //b4: nhập dữ liệu vào ô
        inputUsername.sendKeys("Admin");
        Thread.sleep(3000);
        //b5: tìm kiếm tới vị trí ô input password
        By byInputPassword = By.name("password");
        WebElement inputPassword = chromeDriver.findElement(byInputPassword);
        //b6: nhập dữ liệu vào ô
        inputPassword.sendKeys("admin123");
        Thread.sleep(3000);
        //b7: tìm tới ô Login và ấn click
        By byLoginBtn = By.xpath("//button[@type=\"submit\"]");
        WebElement btnLogin = chromeDriver.findElement(byLoginBtn);
        btnLogin.click();
        Thread.sleep(3000);
        //b8: kiểm tra thành công
        By byTitleSuccess = By.xpath("//h6[text()=\"Dashboard\"]");
        WebElement titleDashboard = chromeDriver.findElement(byTitleSuccess);
        if(titleDashboard.isDisplayed()){
            System.out.println("Đăng nhập thành công");
        }else{
            System.out.println("Đăng nhập không thành công");
        }

        chromeDriver.quit();
    }
}
