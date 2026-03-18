package dtm.data;

import org.testng.annotations.DataProvider;

public class DangNhapData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{

                // tài khoản hợp lệ
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
                {"error_user","secret_sauce"},

                // tài khoản không tồn tại
                {"abc_user","123456"},
                {"test123","password123"},

                // để trống
                {"","secret_sauce"},
                {"standard_user",""},
                {"",""},

                // ký tự đặc biệt
                {"user@123","secret_sauce"},
                {"user#test","secret_sauce"},
                {"!@#$%","123456"},

                // khoảng trắng
                {" standard_user","secret_sauce"},
                {"standard_user ","secret_sauce"},
                {"  standard_user  ","secret_sauce"},

                // null
                {null,"secret_sauce"},
                {"standard_user",null},
                {null,null}

        };

    }

}