package commons;

import core.GlobalConstants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;
    public static FileInputStream fileIn;
    public static FileOutputStream fileOut;
    // get đường dẫn đến file còonfigs.properties
    private static String propertiesFilePath= GlobalConstants.PROJECT_PATH + "\\src\\main\\resources\\configs.properties";


    //để khởi tạo giá trị cho đối tượng properties của class Properties với đường dẫn đến file configs.properties
    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            //Khởi tạo giá trị cho đối tượng của class FileInputStream
            fileIn = new FileInputStream(propertiesFilePath);
            //Load properties file
            properties.load(fileIn);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    //để đọc file đã setup bên trên và lấy giá trị ra theo Key trong file đã tạo
    public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            //get values from properties file
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    //để gán ngược giá trị vói key tương ứng vào lại file properties trên
    public static void setPropValue(String KeyProp, String Value) {
        try {
            //Khởi tạo giá trị cho đối tượng của class FileOutputStream
            fileOut = new FileOutputStream(propertiesFilePath);

            //Load properties file hiện tại và thực hiện mapping value với key tương ứng
            properties.setProperty(KeyProp, Value);

            //Lưu key và value vào properties file
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
