package fiducial;
import TUIO.TuioClient;

public class FiducialTracker {
	private TuioDemoComponent component;

	public FiducialTracker() {
		component = new TuioDemoComponent();
	}

	public void start() {
		TuioClient client = new TuioClient();
		client.addTuioListener(this.component);
		client.connect();
	}
	
	public static void main(String argv[]) {
		FiducialTracker myFiducialTracker = new FiducialTracker();
		myFiducialTracker.start();
	}
}
