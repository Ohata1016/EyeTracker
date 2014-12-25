import com.theeyetribe.client.ITrackerStateListener;


public class MyStateTraceListener implements ITrackerStateListener{
	
	@Override
	public void onTrackerStateChanged(int trackerState) {
		// TODO Auto-generated method stub
		System.out.println(trackerState);
	}

	@Override
	public void onScreenStatesChanged(int screenIndex, int screenResolutionWidth,
			int screenResolutionHeight, float screenPhysicalWidth, float screenPhysicalHeight) {
		// TODO Auto-generated method stub
		System.out.println("screen state change");
	}

	
	
}
