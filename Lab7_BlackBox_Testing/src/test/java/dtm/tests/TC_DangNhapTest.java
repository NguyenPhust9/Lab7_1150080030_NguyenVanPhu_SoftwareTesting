package dtm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dtm.base.BaseTest;
import dtm.pages.LoginPage;
import dtm.data.DangNhapData;

public class TC_DangNhapTest extends BaseTest {

    @Test(
        dataProvider = "du_lieu_dang_nhap",
        dataProviderClass = DangNhapData.class,
        description = "Kiểm thử đăng nhập với nhiều bộ dữ liệu"
    )

    public void kiemThuDangNhap(String username, String password,
                                String ketQuaMongDoi, String moTa) {

        // 1. Khởi tạo LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // 2. Thực hiện đăng nhập
        loginPage.dangNhap(username, password);

        // 3. Kiểm tra kết quả
        switch (ketQuaMongDoi) {

            case "SUCCESS":

                Assert.assertTrue(
                        loginPage.isDangOTrangSanPham(),
                        "Thất bại: " + moTa
                );

                break;

            case "ERROR":

                Assert.assertNotNull(
                        loginPage.layThongBaoLoi(),
                        "Thất bại: " + moTa
                );

                break;

            default:

                Assert.fail("Kết quả mong đợi không hợp lệ: " + moTa);

        }
    }
}