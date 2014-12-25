
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.data.GazeData;


public class GazeListener  implements IGazeListener {
	
	BufferedImage image = null;
	Point beforePont;
	
	public void setImage(BufferedImage img){
		this.image = img;
	}
	
	@Override
	public void onGazeUpdate(GazeData gazeData) {
		// TODO Auto-generated method stub
		int x = (int)gazeData.rawCoordinates.x;
		int y = (int)gazeData.rawCoordinates.y;
		System.out.println("x:" + gazeData.rawCoordinates.x + "y:" + gazeData.rawCoordinates.y);
		
		if(x>1 && y>1){
			if(beforePont!=null){
				drawLine(x,y);				
			}
			beforePont = new Point(x, y);
		}
	}
	
	public void drawLine(int x, int y){
		Graphics2D img = image.createGraphics();
		img.setColor(Color.RED);
		img.setStroke(new BasicStroke(2.0f));
		img.drawLine(x, y, beforePont.x, beforePont.y);
	}

}
