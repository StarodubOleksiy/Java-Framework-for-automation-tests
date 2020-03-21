/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
package controllers;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;
import java.util.Arrays;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader 
{
	
	public ApplicationConfigReader()
	{
		PropertyLoader.newInstance().populate(this);
	}
	
	@Property(value = "Browser")
	private String Browser;
	
	@Property(value="Url")
	private String WebsiteUrl;

	@Property(value="ChromeBrowserVersion")
	private String ChromeVersionDriver;
	
	@Property(value="MaxPageLoadTime")
	private int MaxPageLoadTime;
	
	@Property(value="ImplicitlyWait")
	private int ImplicitlyWait;
	
	@Property(value="VideoFeature")
	private String VideoFeature;

	public String getBrowser() {
        String envBrowser = System.getenv("STE_BROWSER");
        String[] supportBrowsers = {"Firefox", "Chrome", "Opera", "Unit", "Ghost", "Chrome_Headless"};

		if(envBrowser == null){
			return Browser;
		} else {
		    if (Arrays.asList(supportBrowsers).contains(envBrowser)){
                return envBrowser;
            } else {
		        System.out.println("Browser is not supported");
                return "";
            }
		}

	}

	public String getWebsiteUrl() {
	    String url = System.getenv("STE_URL");

        if(url == null || url.isEmpty()){
            return WebsiteUrl;
        } else {
            return url;
        }
	}


	public String getChromeVersionDriver() {
		return ChromeVersionDriver;
	}

	public int getMaxPageLoadTime() {
		return MaxPageLoadTime;
	}

	public int getImplicitlyWait() {
		return ImplicitlyWait;
	}

	public String getVideoFeature() {
		return VideoFeature;
	}
	
	

}
