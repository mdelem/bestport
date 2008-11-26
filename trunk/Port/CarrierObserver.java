import java.awt.Point;

public interface CarrierObserver {

	void containerUnloaded(int carrierID, int containerID);

	void containerLoaded(int carrierID, int containerID);

	void locationChanged(int carrierID, Point location);

	Point askDestination(int carrierID);

	boolean checkUser(String user, String password, String operation);
}
