package data;

import org.testng.annotations.DataProvider;

public class RegisterData {

    @DataProvider(name = "registerData")
    public static Object[][] registerData() {
        return new Object[][]{
                {"test1@gmail.com", "Phu", "Nguyen", "12345", "123 Main St", "New York", "10001", "0123456789"},
                {"test2@gmail.com", "", "Nguyen", "1234", "", "New York", "10001", ""},
                {"invalid", "Phu", "Nguyen", "12345", "123 Main St", "New York", "10001", "0123456789"},
        };
    }
}