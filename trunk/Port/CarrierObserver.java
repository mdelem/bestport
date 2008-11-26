import java.awt.Point;

public interface CarrierObserver {

	void containerUnloaded(SCarrier carrier, int containerID);

	void containerLoaded(SCarrier carrier, int containerID);

	void locationChanged(SCarrier carrier);

	boolean checkUser(String user, String password, String operation);
}
