package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
public class AllureAttachments {
    /**
     * To Attach the Entire Page Screenshot
     */
    @Attachment(value = "Entire page Screenshot of {0}", type = "image/png")
    public static byte[] saveFullPageScreenshot(Platform platform, String name, WebDriver driver) {
        BufferedImage image = null;
        try {
            if (platform == Platform.WEB) {
                image = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver).getImage();
            } else {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                image = ImageIO.read(scrFile);
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
    }

    /**
     * To Convert File to Bytes
     */
    private static byte[] fileToBytes(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }

    /**
     * To Attach the CSV File to the Allure Report
     */
    @Attachment(value = "CSV Attachment", type = "text/csv")
    public static byte[] attachFileType_CSV(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XML File to the Allure Report
     */
    @Attachment(value = "XML Attachment", type = "text/xml")
    public static byte[] attachFileType_XML(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XLSX File to the Allure Report
     */
    @Attachment(value = "MS Excel - XLSX Attachment", type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public static byte[] attachFileType_XLSX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XLS File to the Allure Report
     */
    @Attachment(value = "MS Excel - XLS Attachment", type = "application/vnd.ms-excel")
    public static byte[] attachFileType_XLS(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the TXT File to the Allure Report
     */
    @Attachment(value = "TXT Attachment", type = "text/plain")
    public static byte[] attachFileType_TXT(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the JSON File to the Allure Report
     */
    @Attachment(value = "JSON Attachment", type = "text/json")
    public static byte[] attachFileType_JSON(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the DOCX File to the Allure Report
     */
    @Attachment(value = "MS Word - DOCX Attachment", type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public byte[] attachFileType_DOCX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the DOC File to the Allure Report
     */
    @Attachment(value = "MS Word - DOC Attachment", type = "application/msword")
    public static byte[] attachFileType_DOC(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the JPEG Image File to the Allure Report
     */
    @Attachment(value = "JPEG Attachment", type = "image/jpg")
    public static byte[] attachFileType_JPEG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the PNG Image File to the Allure Report
     */
    @Attachment(value = "PNG Attachment", type = "image/png")
    public static byte[] attachFileType_PNG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

}
