package util;

import driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public abstract class ListenerTest implements ITestListener {
    @Attachment
    private String takeScreenshot() {
        long time = System.currentTimeMillis();
        String filePath = ".//target/allure-results";
        String fileViewPath = "screenshot";
        String fileExt = ".png";
        String fileName = filePath + time + fileExt;
        WebDriver driver = DriverSingleton.getDriver();
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot, new File(fileName));
        } catch (IOException e) {
            System.out.println("Failure to save screenshot:" + e.getLocalizedMessage());
        }
        return fileViewPath + time + fileExt;
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }
}
//    @Override
//    public void onTestStart(ITestResult result) {
//        System.out.println("!!!!!!!!!oneTestStart");
//        Reporter.log("!!!!!!!!!onesTestStart");
//    }
//
//    private String takeScreenshot() {
//        long time = System.currentTimeMillis();
//        String filePath = ".//test-output/screenshots/screenshot";
//        String fileViewPath = "screenshots/screenshot";
//        String fileExt = ".png";
//        String fileName = filePath + time + fileExt;
//        WebDriver driver = DriverSingleton.getDriver();
//        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        try {
//            FileUtils.copyFile(screenShot, new File(fileName));
//        } catch (IOException e) {
//            System.out.println("Faild to save screenshot:" + e.getLocalizedMessage());
//        }
//        return fileViewPath + time + fileExt;
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        System.out.println("!!!!!!!!!oneTestSucces");
//        Reporter.log("!!!!!!!!!onesTestSucces");
//
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("!!!!!!!!!oneTestFailure");
//        Reporter.log("!!!!!!!!!onesTestFailure");
//
//        String filePath = takeScreenshot();
//        Reporter.log("<img src= \"" + filePath + "\">");
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        System.out.println("!!!!!!!!!oneTestSkipped");
//        Reporter.log("!!!!!!!!!onesTestSkipped");
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        System.out.println("!!!!!!!!!onTestFailedButWithinSuccessPercentage");
//        Reporter.log("!!!!!!!!!onTestFailedButWithinSuccessPercentage");
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        System.out.println("!!!!!!!!!onStart");
//        Reporter.log("!!!!!!!!!onStart");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        System.out.println("!!!!!!!!!onFinish");
//        Reporter.log("!!!!!!!!!onFinish");
//    }
//
//}
