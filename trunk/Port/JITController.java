import java.awt.Point;

public class JITController implements CraneObserver, CarrierObserver {

	
	/**
	 * @directed true
	 * @label dispatchs
	 * @supplierCardinality *
	 */
	
	private SCarrier lnkStraddleCarrier;

	private SCarrier findClosestSC() {
				//Commented automatically
				//return;
				return null;
			}

	public void containerLoaded(Crane crane) {
		// TODO Auto-generated method stub
		
	}

	public void containerUnloaded(Crane crane) {
		// TODO Auto-generated method stub
		
	}

	public Point askDestination(SCarrier carrier) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkUser(String user, String password, String operation) {
		// TODO Auto-generated method stub
		return false;
	}

	public void containerLoaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub
		
	}

	public void containerUnloaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub
		
	}

	public void locationChanged(SCarrier carrier) {
		// TODO Auto-generated method stub
		
	}

	
}
