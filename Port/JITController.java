
public class JITController {

	
	
	/**
	 * @directed true
	 * @label fleet
	 */
	
	private SCarrier lnkSCarrier;


	/**
	 * @clientCardinality 1
	 * @directed true
	 * @label port
	 * @supplierCardinality 1
	 */
	
	private PortLocation lnkPortLocation;


	/**
	 * @directed true
	 */

	private Location lnkLocation;

	
	/**
	 * @directed true
	 */
	
	private Container lnkContainer;

	private SCarrier findClosestSC(PortLocation location) {
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

	public void containerLoaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub

	}

	public void containerUnloaded(SCarrier carrier, int containerID) {
		// TODO Auto-generated method stub

	}

	public void destinationReached(SCarrier carrier) {
			// TODO Auto-generated method stub
	
		}

}
