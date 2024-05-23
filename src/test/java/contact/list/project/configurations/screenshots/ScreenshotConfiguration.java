package contact.list.project.configurations.screenshots;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotConfiguration {

    private static String getCurrentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void captureScreenshot(Scenario scenario) {
        TakesScreenshot screenshotTaker = (TakesScreenshot) DriverManager.getDriver();
        String formattedTimestamp = getCurrentDateTime(PropertiesManager.getTimePattern());

        byte[] screenshotBytes = screenshotTaker.getScreenshotAs(OutputType.BYTES);
        String fileName = "Screenshot_" + formattedTimestamp;
        scenario.attach(screenshotBytes, PropertiesManager.getMediaType(), fileName);
        LogManager.getLogger().info("Screenshot attached to report: {}", fileName);

        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        File destinationFile = createScreenshotFile(scenario, formattedTimestamp);
        try {
            FileUtils.copyFile(screenshot, destinationFile);
            LogManager.getLogger().info("Screenshot captured for evidence: {}", destinationFile.getAbsolutePath());
        } catch (IOException e) {
            LogManager.getLogger().error(new ScreenshotCaptureException("Error capturing screenshot", e));
        }
    }

    private static File createScreenshotFile(Scenario scenario, String timestamp) {
        String directoryPath = "reports/evidence/" + getCurrentDateTime(PropertiesManager.getTimePatternForMap());
        File scenarioDirectory = new File(directoryPath, scenario.getName().trim().replaceAll(" ", "_"));
        if (!scenarioDirectory.exists()) {
            if (scenarioDirectory.mkdirs()) {
                LogManager.getLogger().info("Screenshot directory created successfully at: {}", scenarioDirectory.getAbsolutePath());
            }
        }
        String screenshotName = "Screenshot_" + timestamp + ".png";
        return new File(scenarioDirectory, screenshotName);
    }
}
