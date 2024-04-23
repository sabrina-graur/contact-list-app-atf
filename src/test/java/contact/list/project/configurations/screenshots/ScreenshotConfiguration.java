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
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotConfiguration {
    protected static String getCurrentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void captureScreenshot(Scenario scenario) throws ScreenshotCaptureException {
        TakesScreenshot screen = (TakesScreenshot) DriverManager.getDriver();
        String timestamp = getCurrentDateTime(PropertiesManager.getTimePattern());

        byte[] screenshotFile = screen.getScreenshotAs(OutputType.BYTES);
        String fileName = "Screenshot_" + timestamp;
        scenario.attach(screenshotFile, PropertiesManager.getMediaType(), fileName);
        LogManager.getLogger().info("Screenshot attached to report: {}", fileName);

        File screenshot = screen.getScreenshotAs(OutputType.FILE);
        File destinationFile = getFile(scenario, timestamp);
        try {
            FileUtils.copyFile(screenshot, destinationFile);
            LogManager.getLogger().info("Screenshot captured for evidence: {}", destinationFile.getAbsolutePath());
        } catch (IOException e) {
            LogManager.getLogger().error("Exception while taking screenshot: {}", e.getMessage());
            throw new ScreenshotCaptureException("Error capturing screenshot", e);
        }
    }

    private static File getFile(Scenario scenario, String timestamp) {
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

    public static void deleteOldScreenshots() {
        File screenshotsDirectory = new File("target/evidence/");
        File[] scenarioDirectories = screenshotsDirectory.listFiles(File::isDirectory); //(File file) -> file.isDirectory()
        if (scenarioDirectories != null) {
            for (File scenarioDirectory : scenarioDirectories) {
                File[] files = scenarioDirectory.listFiles();
                if (files != null) {
                    long now = System.currentTimeMillis();
                    for (File file : files) {
                        if (file.isFile()) {
                            long creationTime = file.lastModified();
                            long durationInDays = Duration.ofMillis(now - creationTime).toDays();
                            if (durationInDays >= 3) {
                                if (file.delete()) {
                                    LogManager.getLogger().info("Deleted old screenshot: {}", file.getName());
                                } else {
                                    LogManager.getLogger().warn("Failed to delete old screenshot: {}", file.getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
