public class selenium_buoi2 {
    public static void main(String[] args) {
        // thẻ html: button (nút), thẻ tiêu đề (h1 -> h6), thẻ đoạn văn (p, span),
        // thẻ hình ảnh (img), thẻ liên kết (a), thẻ input (ô nhập liệu), thẻ form (biểu mẫu)
        // thẻ div: dùng để chia bố cục trang web, có thể chứa các thẻ khác bên trong
        // cú pháp: <tên thẻ html thuuộc tính(attribute)>nội dung</tên thẻ html>
        // ví dụ: <button>Đăng nhập</button>
        //<a>
        //  <button id="btn" name="login" class="mui-h3">Đăng nhập</button>
        // </a>
        //DOM (Document object model): cấu trúc của trang web để cho selenium/ playwright/ js tương tác

        //locator: ví trí của thẻ html trên trang web
        // 2 loại chính: tương đối và tuyệt đối
        // tuyệt đối (không nên sử dụng): /html/body/div[1]/div/div[1]/header/div/div/div[3]/a[2]/h3
        // vị trí tuyệt đối của thẻ trên trang web dễ bị thay đổi khi có cập nhật cấu trúc html trên web
        // tương đối: dựa vào tên thẻ và thuộc tính của thẻ để xác định vị trí trên trang web
        // thứ tự ưu tiên: id > name > class

        // locator dựa vào id
        // cú pháp: //tên thẻ[@id='giá trị id']
        // ví dụ: //button[@id="btnLogin"]

        //locator dựa vào name
        // cú pháp: //tên thẻ[@name="giá trị name"]
        //ví dụ: //input[@name="password"]

        //locator dựa vào class/className
        //cú pháp: //tên thẻ[@class="giá trị class"]
        // dấu * ở tên thẻ: sẽ không đại diiện cho bất kì thẻ nào, tìm toàn bộ tất cả thẻ

        //button type="", a href="", img src=""
        //cú pháp: //tên thẻ[@thuộc tính="giá trị thuộc tính"]
        //ví dụ: //*[@type="submit"], //a[@href="https://www.google.com/"]

        //locator dựa vào text trong thẻ html
        //cú pháp: //tên thẻ[text()="giá trị text của thẻ"]
        //ví dụ: //button[text()="sign in"]

        //contains: tìm kiếm 1 phần của giá trị thuộc tính hoặc text
        //cú pháp: //tên thẻ[contains(@thuộc tính, "giá trị thuộc tính")],
        //          tên thẻ[contains(text(), "giá trị text")]

        //start-with: tìm kiếm phần đầu của giá trị thuộc tính hoặc text
        //cú pháp: //tên thẻ[starts-with(@thuộc tính, "giá trị thuộc tính")],
        //          tên thẻ[starts-with(text(), "giá trị text")]
        //end-with: tìm kiếm phần cuối của giá trị thuộc tính hoặc text
        //cú pháp: //tên thẻ[ends-with(@thuộc tính, "giá trị thuộc tính")],
        //          tên thẻ[ends-with(text(), "giá trị text")]

        // and và or: kết hợp nhiều điều kiện để tìm kiếm thẻ html
        // cú pháp: //tên thẻ[@thuộc tính1="giá trị thuộc tính1" and @thuộc tính2="giá trị thuộc tính2"]
        //ví dụ: //h3[@class="MuiTypography-root MuiTypography-h3" and text()="Đăng Ký"]
        //cú pháp: //tên thẻ[@thuộc tính1="giá trị thuộc tính1" or @thuộc tính2="giá trị thuộc tính2"]
    }
}
