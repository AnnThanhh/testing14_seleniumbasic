package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class dropDownSelection {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");
        Thread.sleep(3000);

        By byDropDown = By.id("carselect");
        WebElement dropDown = driver.findElement(byDropDown);
        // khởi tạo select và truyền vị trí của dropdown vào
        Select selectCar = new Select(dropDown);
        selectCar.selectByValue("bmw"); // chọn option có value = "bmw"
        selectCar.selectByVisibleText("Honda"); //chọn option có text hiển thị là "Honda"
        selectCar.selectByIndex(1); // chọn option có vị trí index = 1 (vị trí bắt đầu từ 0)

        //dùng để kiểm tra các option có trong dropdown
        List<WebElement> listOptions = selectCar.getOptions();
        //khởi tạo 1 mảng để lưu text của các option
        List<String> listOptionsText = new ArrayList<>();
        for (WebElement option : listOptions) {
            System.out.println(option.getText());
            listOptionsText.add(option.getText());
        }
        System.out.println(listOptionsText); //["BMW", "Benz", "Honda"]
        Thread.sleep(3000);
    }
}
