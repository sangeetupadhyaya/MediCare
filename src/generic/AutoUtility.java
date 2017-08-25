package generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


//Example of method overloading
public class AutoUtility 

{
	/**
	 * Get Screenshot of Desktop
	 * @param path path of the image
	 * @return void
	 */
	
//To get the screenshot of the desktop
	public static void getScreenshot(String path)
	{
		try
		{
			Robot r = new Robot();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect=new Rectangle(screenSize);
			BufferedImage img = r.createScreenCapture(screenRect);
			ImageIO.write(img,"png",new File("./screenshot/a.png"));
		}
		catch(Exception e)
		{
	}

}

//To get screenshot of a page
public static void getScreenshot(WebDriver driver,String path)
{
try
{
	TakesScreenshot t = (TakesScreenshot)driver;
	File image = t. getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(image,new File(path));
}
catch(Exception e)
{
}
}

public static String now(){
		SimpleDateFormat s = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
				String timeStamp=s.format(new Date(0));
				return timeStamp;
	}
	
	public static String getPropertyValue(String path,String key)
	{
		String value="";
		try{
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value =p.getProperty(key);
		}
		catch(Exception e)
		{
		}
		return value;

		}
	
public static void sleep(int seconds)
{
	try
	{
		Thread.sleep(seconds*1000);
	}
	catch(InterruptedException e)
	{
	}
	
	
	}
}
