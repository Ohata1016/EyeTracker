
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;

public class EyeTrackerMain{


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EyeTrackerMain test = new EyeTrackerMain();
		test.run();
	}

	public void run() {
		EyeTrackerController controller = new EyeTrackerController();
	}
	

	
}
