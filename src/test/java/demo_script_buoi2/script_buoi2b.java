package demo_script_buoi2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

public class script_buoi2b {
    public static void main(String[] args) throws InterruptedException {
        String account = UUID.randomUUID().toString();  //xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx(v4 - toàn đều là random số và chữ cái) -> o^n
                                                        //v7: xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx -> o^n/2
        String email = account + "@gmail.com";

        //b1: khởi tạo chromeOption và chromeDriver
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        //b2: truy cập vào https://demo1.cybersoft.edu.vn/
        chromeDriver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);
        //b3: ấn vào nút đăng ký
        By byBtnRegister = By.xpath("//h3[text()=\"Đăng Ký\"]");
        WebElement btnRegister = chromeDriver.findElement(byBtnRegister);
        btnRegister.click();
        Thread.sleep(3000);
        //b4: truy cập vào tài khoản và nhập dữ liệu
        By byInputUserName = By.id("taiKhoan");
        WebElement inputUserName = chromeDriver.findElement(byInputUserName);
        inputUserName.sendKeys(account);

        By byInputPassword = By.id("matKhau");
        WebElement inputPassword = chromeDriver.findElement(byInputPassword);
        inputPassword.sendKeys("Cybersoft@123");

        By byConfirmPassword = By.id("confirmPassWord");
        WebElement inputConfirmPassword = chromeDriver.findElement(byConfirmPassword);
        inputConfirmPassword.sendKeys("Cybersoft@123");

        By byInputHoTen = By.id("hoTen");
        WebElement inputHoTen = chromeDriver.findElement(byInputHoTen);
        inputHoTen.sendKeys("Trịnh An Thành");

        By byInputEmail = By.id("email");
        WebElement inputEmail = chromeDriver.findElement(byInputEmail);
        inputEmail.sendKeys(email);
        Thread.sleep(3000);

        By btnClickRegister = By.xpath("//button[@type=\"submit\"]");
        WebElement btnRegisterClick = chromeDriver.findElement(btnClickRegister);
        btnRegisterClick.click();
        Thread.sleep(3000);
        //b9: ấn nút đăng ký
        chromeDriver.quit();
    }
}
