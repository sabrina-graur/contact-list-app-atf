package contact.list.project.configurations.screenshots;

import contact.list.project.configurations.driverfactory.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotConfiguration {
    private static final Logger LOG = LogManager.getLogger(ScreenshotConfiguration.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");

    public static void captureScreenshot() {
        try {
            TakesScreenshot screen = (TakesScreenshot) DriverManager.getDriver();
            File screenshotFile = screen.getScreenshotAs(OutputType.FILE);
            String timestamp = dateFormat.format(new Date());
            String destinationPath = "target/evidence/screenshots/" + "Screenshot_" + timestamp + ".png";
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            LOG.info("Screenshot captured: " + destinationPath);
        } catch (
                IOException e) {
            LOG.error("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
