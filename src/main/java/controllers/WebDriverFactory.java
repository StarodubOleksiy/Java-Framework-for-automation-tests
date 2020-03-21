/**
 * 
 */
package controllers;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;

/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
public class WebDriverFactory extends BrowserFactory
{
	public static WebDriver wd;
//	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	public void setupVideoRecordingFailedOnly() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Videos")     					// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.FAILED_ONLY)     	// Save videos ONLY FAILED tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;							// Record video only for tests with @Video
	}
	
	public void setupVideoRecordingAll() throws Exception
	{
		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Videos")     					// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.ALL)     						// Save videos All tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;							// Record video only for tests with @Video
	}

	public void setWebDriver(WebDriver driver) 
	{
		wd = driver;
	}

	public static WebDriver getWebDriver() 
	{
		return wd;
	}
}
