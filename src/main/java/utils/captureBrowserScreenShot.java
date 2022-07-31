package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class captureBrowserScreenShot {
	List<ArrayList<BufferedImage>> imageslist;
	

	
	public void seleniumCaptureBrowserScreenShot(WebDriver driver, String ImgPath,ExtentTest eTest) throws InterruptedException, IOException {
		try{
		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000))
                .takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(ImgPath));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
