package UIInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableHandle {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");
        Thread.sleep(3000); // hard wait

//            <table>
//                <thead>
//                      tr
//                          th: header 1
//                </thead>
//                <tbody>
//                      tr
//                          td:
//                </tbody>
//            </table>
        String tableLocator = "//table[@id=\"product\"]";
        String cellValue = getTableBodyValue(driver, tableLocator, 2,2);
        System.out.println(cellValue);
        driver.quit();
    }
    //[%s]: dynamic string
    //[%d]: dynamic integer
    public static String getTableBodyValue(WebDriver driver, String tableLocator, int row, int col ){
        //tạo dynamic locator cho ví trí cần lấy dữ liệu
        String cellDynamicLocator = tableLocator + "//tbody//tr[%d]//td[%d]";
        String cellLocator = String.format(cellDynamicLocator, row, col);
        //tìm tới ví trí của cell cần lấy dữ liệu dựa trên dynamic locator
        WebElement cell = driver.findElement(By.xpath(cellLocator));
        return cell.getText();
    }
    //header mẫu
    public static String getTableHeaderValue(WebDriver driver, String tableLocator, int col ){
        //tạo dynamic locator cho ví trí cần lấy dữ liệu
        String cellDynamicLocator = tableLocator + "//thead//tr//th[%d]";
        String cellLocator = String.format(cellDynamicLocator, col);
        //tìm tới ví trí của cell cần lấy dữ liệu dựa trên dynamic locator
        WebElement cell = driver.findElement(By.xpath(cellLocator));
        return cell.getText();
    }

    public static boolean isCellDataExist (WebDriver driver, String tableLocator, String expectedData){
        //Logic

        return true;
    }

    public static String getTableCellByColName (WebDriver driver, String tableLocator, String colName, int row){
        //Logic

        return "";
    }
}
