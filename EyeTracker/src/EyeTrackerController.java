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


public class EyeTrackerController implements ControlPanelEventListener{

	private ControlPanel frame = new ControlPanel(this);
	BufferedImage image = null;
	
	
	public void initialize(){
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			frame.addListener(this);
		} catch (HeadlessException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void startRecording(){
		final GazeManager gm = GazeManager.getInstance();
		boolean success = gm.activate(ApiVersion.VERSION_1_0, ClientMode.PUSH);

		if(success){
			System.out.println("success connect");
		}else{
			System.out.println("fail connect");
		}
		
		GazeListener gazeListener = new GazeListener();
		gazeListener.setImage(image);
		
		MyStateTraceListener stateListener = new MyStateTraceListener();
		
		gm.addGazeListener(gazeListener);
		gm.addTrackerStateListener(stateListener);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				gm.removeGazeListener(gazeListener);
				gm.deactivate();
			}
		});
	}

	@Override
	public void controlled(int eventType) {
		// TODO Auto-generated method stub
		if(eventType==ControlPanelEventListener.STOP){
			try {
				ImageIO.write(image, "png", new File("img/" + "test" + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GazeManager.getInstance().clearListeners();
			GazeManager.getInstance().deactivate();
		}
		if(eventType == ControlPanelEventListener.START){
			initialize();
			startRecording();

		}
	}
}
