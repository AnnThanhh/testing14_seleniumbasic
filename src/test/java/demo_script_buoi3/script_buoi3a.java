package demo_script_buoi3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class script_buoi3a {

    public static void main(String[] args) throws InterruptedException {
        //bước 1: khởi tạo webdriver và chrome option
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        //bước 2: truy cập vào trang
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        //bước 3: đăng nhập vào trang
        By byInputUsername = By.name("username");
        WebElement inputUsername =chromeDriver.findElement(byInputUsername);
        inputUsername.sendKeys("Admin");

        By byInputPassword = By.name("password");
        WebElement inputPassword = chromeDriver.findElement(byInputPassword);
        inputPassword.sendKeys("admin123");

        By byLoginBtn = By.xpath("//button[@type=\"submit\"]");
        WebElement btnLogin = chromeDriver.findElement(byLoginBtn);
        btnLogin.click();
        Thread.sleep(3000);
        //bước 4: điều hướng sang trang PIM
        By byPIM = By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]");
        ////span[text()="PIM"]
        WebElement btnPIM = chromeDriver.findElement(byPIM);
        btnPIM.click();
        Thread.sleep(3000);
        //bước 5: ấn vào nút add employee
        By byAddEmployee = By.xpath("//a[text()=\"Add Employee\"]");
        WebElement btnAddEmployee = chromeDriver.findElement(byAddEmployee);
        btnAddEmployee.click();
        Thread.sleep(3000);
        //bước 6: nhập dữ liệu vào ô first name, last name,
        By byInputFirstName = By.name("firstName");
        //input[@name="firstName"]
        WebElement inputFirstName = chromeDriver.findElement(byInputFirstName);
        inputFirstName.sendKeys("AT");

        By byInputLastName = By.name("lastName");
        WebElement inputLastName = chromeDriver.findElement(byInputLastName);
        inputLastName.sendKeys("Trịnh");
        //bước 7: ấn vào nút save
        By btnSave = By.xpath("//button[@type=\"submit\"]");
        WebElement btnSaveEmployee = chromeDriver.findElement(btnSave);
        btnSaveEmployee.click();
        Thread.sleep(10000);
        //bước 8: kiểm tra thêm nhân viên thành công
        // (coi thử có xuất hiện personal details hay không)
        By byPersonalDetails = By.xpath("//h6[text()=\"Personal Details\"]");
        WebElement titlePersonalDetails = chromeDriver.findElement(byPersonalDetails);
        if(titlePersonalDetails.isDisplayed()){
            System.out.println("Thêm nhân viên thành công");
        }else{
            System.out.println("Thêm nhân viên không thành công");
        }
        chromeDriver.quit();
    }
}
