
public interface ControlPanelEventListener {
	
	public static int STOP = 0;
	public static int START = 1;
	
	public void controlled(int eventType);
	
	
}
